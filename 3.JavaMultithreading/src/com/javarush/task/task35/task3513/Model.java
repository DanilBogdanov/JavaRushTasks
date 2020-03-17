package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;

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

}
