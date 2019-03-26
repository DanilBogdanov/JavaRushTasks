package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Создать массив на 20 чисел.
Заполнить его числами с клавиатуры.
Найти максимальное и минимальное числа в массиве.
Вывести на экран максимальное и минимальное числа через пробел.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];

        array[0] = Integer.parseInt(reader.readLine());

        int maximum = array[0];
        int minimum = array[0];

        int buffer;
        for (int i = 1; i < array.length; i++) {
            buffer = Integer.parseInt(reader.readLine());
            array[i] = buffer;
            maximum = (maximum > buffer) ? maximum : buffer;
            minimum = (minimum < buffer) ? minimum : buffer;
        }//напишите тут ваш код

        System.out.print(maximum + " " + minimum);
    }
}
