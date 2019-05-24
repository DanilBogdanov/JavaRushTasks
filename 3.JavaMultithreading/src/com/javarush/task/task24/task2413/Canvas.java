package com.javarush.task.task24.task2413;

public class Canvas {
    private int width;
    private int height;
    private char[][] matrix;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        matrix = new char[height + 2][width + 2];
    }

    public void setPoint(double x, double y, char c) {
        int iX = (int) Math.round(x);
        int iY = (int) Math.round(y);

        if (!(iX < 0 || iY < 0 || iX >= matrix.length || iY >= matrix[0].length)) {
            matrix[iY][iX] = c;
        }
    }

    public void drawMatrix(double x, double y, int[][] matrix, char c) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    setPoint(j + x, i + y, c);
                }
            }
        }
    }
}
