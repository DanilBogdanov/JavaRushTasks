package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    private Stack<Tile[][]> previousStates = new Stack<>();
    private Stack<Integer> previousScores = new Stack<>();
    int score = 0;
    int maxTile = 0;
    boolean isSaveNeeded = true;

    boolean hasBoardChanged() {
        return getSummTiles(gameTiles) != getSummTiles(previousStates.peek());
    }

    MoveEfficiency getMoveEfficiency(Move move) {
        move.move();
        if (!hasBoardChanged()) {
            rollback();
            return new MoveEfficiency(-1, 0, move);
        }
        int numberOfEmptyTiles = getNumberOfEmptyTiles(gameTiles);
        MoveEfficiency moveEfficiency = new MoveEfficiency(getNumberOfEmptyTiles(gameTiles),
                score, move);
        rollback();
        return moveEfficiency;
    }

    private int getSummTiles(Tile[][] tiles) {
        int summ = 0;

        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                summ += tiles[i][j].value;
            }
        }

        return summ;
    }

    private int getNumberOfEmptyTiles(Tile[][] tiles) {
        int result = 0;

        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (tiles[i][j].isEmpty()) {
                    result++;
                }
            }
        }

        return result;
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    private void saveState(Tile[][] tiles) {
        previousStates.push(copyTiles(tiles));
        previousScores.push(score);
        isSaveNeeded = false;
    }

    public void rollback() {
        if (!previousStates.isEmpty() && !previousScores.isEmpty()) {
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }

    boolean canMove() {
        for (Tile[] tiles : gameTiles) {
            for (Tile tile : tiles) {
                if (tile.value == 0) {
                    return true;
                }
            }
        }

        for (int i = 0; i < FIELD_WIDTH - 1; i++) {
            for (int j = 0; j < FIELD_WIDTH - 1; j++) {
                if (gameTiles[i][j].value == gameTiles[i][j + 1].value
                        || gameTiles[j][i].value == gameTiles[j + 1][i].value) {
                    return true;
                }
            }
        }

        return false;
    }

    public Model() {
        resetGameTiles();
    }

    private void addTile() {
        int weightTile = Math.random() < 0.9 ? 2 : 4;

        List<Tile> emptyTiles = getEmptyTiles();
        if (!emptyTiles.isEmpty()) {
            int index = (int) (Math.random() * emptyTiles.size());
            emptyTiles.get(index).value = weightTile;
        }
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> result = new ArrayList<>();

        for (Tile[] tiles : gameTiles) {
            for (Tile tile : tiles) {
                if (tile.isEmpty()) {
                    result.add(tile);
                }
            }
        }

        return result;
    }

    void resetGameTiles() {
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];

        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                gameTiles[i][j] = new Tile();
            }
        }

        addTile();
        addTile();
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean resultChange = false;
        boolean changed = true;

        while(changed) {
            changed = false;

            for (int i = 1; i < tiles.length; i++) {
                if (!tiles[i].isEmpty() && tiles[i-1].isEmpty()) {
                    tiles[i-1].value = tiles[i].value;
                    tiles[i].value = 0;
                    changed = true;
                    resultChange = true;
                }
            }
        }

        return resultChange;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean resultChange = false;
        for (int i = 0; i < tiles.length - 1; i++) {
            if (tiles[i].value == tiles[i + 1].value && !tiles[i].isEmpty()) {
                int doubleValue = tiles[i].value + tiles[i + 1].value;
                tiles[i].value = doubleValue;
                tiles[i + 1].value = 0;
                score += doubleValue;
                maxTile = (doubleValue > maxTile) ? doubleValue : maxTile;
                i++;
                resultChange = true;
            }
        }
        if (resultChange) {
            compressTiles(tiles);
        }
        return resultChange;
    }

    void left() {
        boolean changed = false;
        boolean hasCompressed;
        boolean hasMerged;

        if (isSaveNeeded) {
            saveState(gameTiles);
        }

        for (int i = 0; i < gameTiles.length; i++) {
            hasCompressed = compressTiles(gameTiles[i]);
            hasMerged = mergeTiles(gameTiles[i]);
            if (hasCompressed || hasMerged) {
                changed = true;
            }
        }

        if (changed) {
            addTile();
        }

        isSaveNeeded = true;
    }

    void up() {
        saveState(gameTiles);
        rotateArray();
        rotateArray();
        rotateArray();
        left();
        rotateArray();
    }

    void right() {
        saveState(gameTiles);
        rotateArray();
        rotateArray();
        left();
        rotateArray();
        rotateArray();
    }

    void down() {
        saveState(gameTiles);
        rotateArray();
        left();
        rotateArray();
        rotateArray();
        rotateArray();
    }

     private void rotateArray() {
        Tile[][] rotatedArray = new Tile[FIELD_WIDTH][FIELD_WIDTH];

        for (int i = 0; i < rotatedArray.length; i++) {
            for (int j = 0; j < rotatedArray[i].length; j++) {
                rotatedArray[i][j] = gameTiles[gameTiles.length - 1 - j][i];
            }
        }
        gameTiles = rotatedArray;
    }

    void randomMove() {
        int item = ((int) (Math.random() * 100)) % 4;

        switch (item) {
            case 0:
                left();
                break;
            case 1:
                right();
                break;
            case 2:
                up();
                break;
            case 3:
                down();
                break;
        }
    }

    void autoMove() {
        PriorityQueue<MoveEfficiency> priorityQueue = new PriorityQueue<MoveEfficiency>(4, Collections.reverseOrder());
        Move moveLeft = () -> left();
        Move moveRight = () -> right();
        Move moveUp = () -> up();
        Move moveDown = () -> down();

        priorityQueue.add(getMoveEfficiency(moveLeft));
        priorityQueue.add(getMoveEfficiency(moveRight));
        priorityQueue.add(getMoveEfficiency(moveUp));
        priorityQueue.add(getMoveEfficiency(moveDown));

        if (!priorityQueue.isEmpty()) {
            priorityQueue.poll().getMove().move();
        }
    }

    private Tile[][] copyTiles(Tile[][] tiles) {
        Tile[][] resultTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                resultTiles[i][j] = new Tile();
                resultTiles[i][j].value = tiles[i][j].value;
            }
        }
        return resultTiles;
    }



}
