package com.javarush.task.task25.task2515;
/*Что мы будем делать с Canvas?
Поэтому нам понадобятся два метода:
public void setPoint(double x, double y, char c),
public void drawMatrix(double x, double y, int[][] matrix, char c).

Первый метод - setPoint будет "ставить точку в координатах x,y цветом c".
В методе надо:
а) округлить x и y до целых чисел,
б) занести в matrix[y][x] значение с,
в) ничего не делать, если x<0 или y<0 или y>=matrix.length или x>=matrix[0].length.

Второй метод - drawMatrix копирует переданную ему картинку (матрицу) в матрицу Canvas.
И не просто копирует, а начиная с координат x, y.

В методе надо:
а) с помощью двух вложенных циклов пройтись по всем ячейкам переданной картинки,
б) если значение ячейки matrix[i][j] не равно 0, то покрасить в матрице объекта Canvas точку (x+j, y+i) в цвет c:
setPoint(x+j, y+i, c)
*/
public class Canvas {
    private int width;
    private int height;
    private char[][] matrix;

    public void setPoint(double x, double y, char c) {
        if (x >= 0 && y >= 0 && x < matrix[0].length && y < matrix.length) {
            matrix[(int) Math.round(y)][(int) Math.round(x)] = c;
        }
    }

    public void drawMatrix(double x, double y, int[][] matrix, char c) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    setPoint(j + x,i + y, c);
                }
            }
        }
    }

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.matrix = new char[height][width];
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
}
