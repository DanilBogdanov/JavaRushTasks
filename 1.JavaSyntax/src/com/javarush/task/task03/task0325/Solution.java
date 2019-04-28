package com.javarush.task.task03.task0325;

import java.io.*;

/* 
Ввести с клавиатуры число n.
Вывести на экран надпись "Я буду зарабатывать $n в час".
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        System.out.printf("Я буду зарабатывать $%s в час", s);
    }
}
