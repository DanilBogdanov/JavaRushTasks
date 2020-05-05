package com.javarush.task.task32.task3210;

/* 
Используем RandomAccessFile
*/

import java.io.IOException;
import java.io.RandomAccessFile;

public class Solution {
    public static void main(String... args) throws IOException {
        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];

        byte[] bytesOfText = text.getBytes();
        byte[] bytesOfString = new byte[bytesOfText.length];

        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
        raf.seek(number);
        raf.read(bytesOfString, 0, text.length());
        raf.seek(raf.length());
        if (new String(bytesOfString).equals(new String(bytesOfText))) {
            raf.write("true".getBytes());
        } else {
            raf.write("false".getBytes());
        }
    }
}
