package com.javarush.task.task04.task0441;


/* 
Ввести с клавиатуры три числа, вывести на экран среднее из них.
Т.е. не самое большое и не самое маленькое.
Если все числа равны, вывести любое из них.
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        int max = a;
        int min = a;

        if (b > max) {
            max = b;
        } else {
            min = b;
        }

        if (c > max) max = c;
        if (c < min) min = c;

        System.out.println((a + b + c) - max - min);

    }
}
