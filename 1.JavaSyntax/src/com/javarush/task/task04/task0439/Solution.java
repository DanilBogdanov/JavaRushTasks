package com.javarush.task.task04.task0439;

/* 
Ввести с клавиатуры имя и используя цикл for 10 раз вывести: "*имя* любит меня."
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s любит меня.", name);
            System.out.println();
        }

    }
}
