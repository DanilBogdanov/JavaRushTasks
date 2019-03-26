package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую короткую строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.


*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> strings = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lessString = 0;
        String buffer;


        for (int i = 0; i < 5; i++) {
            buffer = reader.readLine();
            strings.add(buffer);
            if (i == 0) {
                lessString = buffer.length();
            } else {
                lessString = (lessString < buffer.length()) ? lessString : buffer.length();
            }
        }

        for (String s : strings) {
            if (lessString == s.length()) {
                System.out.println(s);
            }
        }


    }
}
