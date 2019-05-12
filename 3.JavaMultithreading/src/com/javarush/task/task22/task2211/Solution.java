package com.javarush.task.task22.task2211;

import java.io.*;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String firstFileName = args[0];
        String secondFileName = args[1];

        try (FileInputStream fileReader = new FileInputStream(firstFileName);
             FileOutputStream fileWriter = new FileOutputStream(secondFileName)) {

            String stringBuffer;
            while (fileReader.available() > 0) {
                byte[] buffer = new byte[1000];
                int length = fileReader.read(buffer);
                stringBuffer = new String(buffer, 0, length, "Windows-1251");
                fileWriter.write(stringBuffer.getBytes("UTF-8"));
            }
        }
    }
}
