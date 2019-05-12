package com.javarush.task.task23.task2312;

public class Room {
    public static Room game;

    private int width;
    private int height;
    private Snake snake;
    private Mouse mouse;

    public Room(int width, int height, Snake snake) {
        setWidth(width);
        setHeight(height);
        setSnake(snake);
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public static void main(String[] args) {
        Snake snake = new Snake(1, 1);
        snake.setDirection(SnakeDirection.DOWN);
        game = new Room(10, 10, snake);


    }

    public void run() {

    }

    public void print() {

    }
}
