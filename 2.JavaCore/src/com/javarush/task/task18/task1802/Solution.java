package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
Ввести с консоли имя файла.
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        int minByte = fis.read();
        int buffer;

        while (fis.available() > 0) {
            buffer = fis.read();
            if (buffer < minByte) {
                minByte = buffer;
            }
        }

        System.out.println(minByte);
        fis.close();
    }
}
