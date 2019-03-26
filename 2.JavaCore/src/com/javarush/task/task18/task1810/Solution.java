package com.javarush.task.task18.task1810;

/* 
DownloadException
1 Считывать с консоли имена файлов.
2 Если файл меньше 1000 байт, то:
2.1 Закрыть потоки работы с файлами.
2.2 Выбросить исключение DownloadException.
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                FileInputStream fis = new FileInputStream(reader.readLine());
                long countByte = fis.available();
                fis.close();
                if (countByte < 1000) {
                    throw new DownloadException();
                }
            }
        } catch (IOException e) {

        }

    }

    public static class DownloadException extends Exception {

    }
}
