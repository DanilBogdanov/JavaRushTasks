package com.javarush.task.task18.task1807;

/* 
С консоли считать имя файла.
Посчитать в файле количество символов ',', количество вывести на консоль.
Закрыть потоки.

Подсказка:
нужно сравнивать с ascii-кодом символа ','. 44

*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        int countOfComma = 0;

        while (fis.available() > 0) {
            byte[] buffer = new byte[1000];
            int count = fis.read(buffer);

            for (int i = 0; i < count; i++) {
                if (buffer[i] == 44) countOfComma++;
            }
        }

        System.out.println(countOfComma);
        reader.close();
        fis.close();
    }
}
