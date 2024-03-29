package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
1. Создай список строк.
2. Добавь в него 10 строчек с клавиатуры.
3. Узнай, какая строка в списке встретится раньше: самая короткая или самая длинная.
Если таких строк несколько, то должны быть учтены самые первые из них.
4. Выведи на экран строку из п.3. Должна быть выведена одна строка.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> strings = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int minString = 0;
        int maxString = 0;
        String buffer;

        for (int i = 0; i < 10; i++) {
            buffer = reader.readLine();
            strings.add(buffer);
            minString = (strings.get(minString).length() <= buffer.length()) ? minString : i;
            maxString = (strings.get(maxString).length() >= buffer.length()) ? maxString : i;
        }

        if (minString < maxString) {
            System.out.println(strings.get(minString));
        } else {
            System.out.println(strings.get(maxString));
        }
    }
}
