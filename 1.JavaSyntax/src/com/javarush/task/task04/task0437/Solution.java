package com.javarush.task.task04.task0437;


/* 
Треугольник из восьмерок
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            for (int y = 0; y <= i; y++) {
                System.out.print(8);
            }
            System.out.println();
        }
    }
}
