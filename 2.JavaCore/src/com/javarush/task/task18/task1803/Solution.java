package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
Ввести с консоли имя файла.
Найти байт или байты с максимальным количеством повторов.
Вывести их на экран через пробел.
Закрыть поток ввода-вывода.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        int[] bytes = new int[256];

        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = 0;
        }

        while (fis.available() > 0) {
            bytes[fis.read()]++;
        }

        int max = 0;
        for (int i : bytes) {
            if (i > max)
                max = i;
        }

        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] == max) {
                System.out.print(i + " ");
            }
        }

        fis.close();
    }
}
