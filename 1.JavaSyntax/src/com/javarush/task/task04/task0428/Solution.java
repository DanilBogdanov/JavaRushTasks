package com.javarush.task.task04.task0428;

/* 
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных чисел среди этих трех.


*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine()) > 0 ? 1 : 0;
        int b = Integer.parseInt(reader.readLine()) > 0 ? 1 : 0;
        int c = Integer.parseInt(reader.readLine()) > 0 ? 1 : 0;

        System.out.println(a + b + c);
    }
}
