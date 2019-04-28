package com.javarush.task.task04.task0429;

/* 
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных и количество отрицательных чисел в исходном наборе,
в следующем виде:
"количество отрицательных чисел: а", "количество положительных чисел: б",
где а, б - искомые значения.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int positive = 0;
        int negative = 0;

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        if (a != 0) {
            if (a > 0) {
                positive++;
            } else {
                negative++;
            }
        }

        if (b != 0) {
            if (b > 0) {
                positive++;
            } else {
                negative++;
            }
        }

        if (c != 0) {
            if (c > 0) {
                positive++;
            } else {
                negative++;
            }
        }

        System.out.printf("количество отрицательных чисел: %s", negative);
        System.out.printf("количество положительных чисел: %s", positive);

    }


}
