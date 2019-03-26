package com.javarush.task.task04.task0424;

/* 
Ввести с клавиатуры три целых числа. Одно из чисел отлично от двух других, равных между собой.
 Вывести на экран порядковый номер числа, отличного от остальных.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        if (b == c) System.out.println("1");
        if (a == c) System.out.println("2");
        if (b == a) System.out.println("3");
    }
}
