package com.javarush.task.task35.task3513;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter {
    private Model model;
    private View view;
    private static final int WINNING_TILE = 2048;

    public Controller(Model model) {
        this.model = model;
        view = new View(this);
    }

    public View getView() {
        return view;
    }

    void resetGame() {
        model.score = 0;
        model.maxTile = 0;
        view.isGameWon = false;
        view.isGameLost = false;
        model.resetGameTiles();

    }

    Tile[][] getGameTiles() {
        return model.getGameTiles();
    }

    int getScore() {
        return model.score;
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_ESCAPE) {
            resetGame();
        } else {
            if (!model.canMove()) {
                view.isGameLost = true;
            }

            if (!view.isGameWon && !view.isGameLost) {
                switch (keyEvent.getKeyCode()) {
                    case KeyEvent.VK_Z:
                        model.rollback();
                        break;
                    case KeyEvent.VK_R:
                        model.randomMove();
                        break;
                    case KeyEvent.VK_A:
                        model.autoMove();
                        break;
                    case KeyEvent.VK_RIGHT:
                        model.right();
                        break;
                    case KeyEvent.VK_LEFT:
                        model.left();
                        break;
                    case KeyEvent.VK_UP:
                        model.up();
                        break;
                    case KeyEvent.VK_DOWN:
                        model.down();
                        break;
                }

                if (model.maxTile == WINNING_TILE) {
                    view.isGameWon = true;
                }
            }
        }

        view.repaint();
    }
}
