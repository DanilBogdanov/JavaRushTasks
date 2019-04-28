package com.javarush.task.task15.task1507;

/* 
ООП - Перегрузка
Перегрузите метод printMatrix 8 различными способами. В итоге должно получиться 10 различных методов printMatrix.
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printMatrix(String value) {}
    public static void printMatrix(String value, int i) {}
    public static void printMatrix(Integer i) {}
    public static void printMatrix(double d) {}
    public static void printMatrix(short s) {}
    public static void printMatrix(char c) {}
    public static void printMatrix(short s, short t) {}
    public static void printMatrix(long s) {}

}
