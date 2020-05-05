package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Path;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws IOException {
        //args = new String[]{"/home/danil/test/2.txt", "10", "fuck"};
        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];

        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
        byte[] buffer = text.getBytes();
        long len = raf.length();

        if (number + buffer.length > len) {
            raf.seek(len );
            raf.write(buffer);
        } else {
            raf.seek(number);
            raf.write(buffer);
        }
    }
}
