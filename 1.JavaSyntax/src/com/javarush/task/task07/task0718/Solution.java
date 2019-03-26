package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
Проверка на упорядоченность
1. Введи с клавиатуры 10 слов в список строк.
2. Определить, является ли список упорядоченным по возрастанию длины строки.
3. В случае отрицательного ответа вывести на экран индекс первого элемента, нарушающего такую упорядоченность.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean isFind = false;
        int minI = 0;

        list.add(reader.readLine());

        for (int i = 1; i < 10; i++) {
            list.add(reader.readLine());

            if (!isFind) {
                if (list.get(i - 1).length() > list.get(i).length()) {
                    minI = i;
                    isFind = true;
                } else {
                    minI = i;
                }
            }
        }

        if (isFind) {
            System.out.println(minI);
        }

    }
}

