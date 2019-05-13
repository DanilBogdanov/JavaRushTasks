package com.javarush.task.task23.task2312;

import java.util.List;
import java.util.ArrayList;

public class Snake {
    private List<SnakeSection> sections;
    private boolean isAlive;
    private SnakeDirection direction;

    public List<SnakeSection> getSections() {
        return sections;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    public Snake(int x, int y) {
        sections = new ArrayList<>();
        sections.add(new SnakeSection(x, y));
        isAlive = true;
    }

    public int getX() {
        return sections.get(0).getX();
    }

    public int getY() {
        return sections.get(0).getY();
    }

    public void move() {
        if (isAlive()) {
            switch (direction) {
                case UP :
                    move(0, -1);
                    break;
                case RIGHT:
                    move(1, 0);
                    break;
                case DOWN:
                    move(0, 1);
                    break;
                case LEFT:
                    move(-1, 0);
                    break;
            }
        }
    }

    public void move(int x, int y) {

    }
}
