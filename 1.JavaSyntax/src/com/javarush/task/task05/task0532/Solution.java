package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Написать программу, которая:
1. считывает с консоли число N, которое должно быть больше 0
2. потом считывает N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int buffer = Integer.parseInt(reader.readLine());
        int maximum = buffer;

        for (int i = 0; i < n - 1; i++) {
            maximum = (maximum > (buffer = Integer.parseInt(reader.readLine())) ? maximum : buffer);
        }

        //напишите тут ваш код

        System.out.println(maximum);
    }
}
