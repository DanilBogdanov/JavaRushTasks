package com.javarush.task.task35.task3513;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    int score = 0;
    int maxTile = 0;

    public Tile[][] getGameTiles() {
        return gameTiles;
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
    }

    void up() {
        rotateArray();
        rotateArray();
        rotateArray();
        left();
        rotateArray();
    }

    void right() {
        rotateArray();
        rotateArray();
        left();
        rotateArray();
        rotateArray();
    }

    void down() {
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



}
