package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Самая длинная строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую длинную строку в списке.
4. Выведи найденную строку на экран. Если таких строк несколько, выведи каждую с новой строки
*/

public class Solution {
    private static List<String> strings;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        strings = new ArrayList<>();
        int maxLength = 0;
        String buffer;

        for(int i = 0; i < 5; i++) {
            buffer = reader.readLine();
            strings.add(buffer);
            maxLength = (maxLength > buffer.length()) ? maxLength : buffer.length();
        }

        for (String s : strings) {
            if (s.length() == maxLength) {
                System.out.println(s);
            }
        }
    }
}
