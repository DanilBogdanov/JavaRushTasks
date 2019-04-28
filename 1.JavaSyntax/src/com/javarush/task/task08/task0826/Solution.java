package com.javarush.task.task08.task0826;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/* 
Пять победителей
Создать массив на 20 чисел.
Заполнить его числами с клавиатуры.
Вывести пять наибольших чисел.
Каждое значение с новой строки.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println(array[4]);
    }

    public static void sort(int[] array) {
        boolean isChanged = true;
        while (isChanged) {
            isChanged = false;
            for (int i = 1; i < array.length; i++) {
                if (array[i] > array[i - 1]) {
                    array[i] = array[i] + array[i - 1];
                    array[i - 1] = array[i] - array[i - 1];
                    array[i] = array[i] - array[i - 1];
                    isChanged = true;
                }
            }

        }
    }
}
