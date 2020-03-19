package com.javarush.task.task35.task3513;

import java.awt.event.KeyAdapter;

public class Controller extends KeyAdapter {
    Model model;

    Tile[][] getGameTiles() {
        return model.getGameTiles();
    }

    int getScore() {
        return model.score;
    }
}
