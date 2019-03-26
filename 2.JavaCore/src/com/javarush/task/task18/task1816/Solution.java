package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        int countAlphabet = 0;
        String fileName = args[0];
        FileInputStream fis = new FileInputStream(fileName);
        byte[] buffer = new byte[1000];

        while (fis.available() > 0) {
            int count = fis.read(buffer);

            for (int i = 0; i < count; i++) {
                //65-90 97-122
                byte element = buffer[i];
                if ((element >= 65 && element <= 90) || (element >= 97 && element <= 122)) {
                    countAlphabet++;
                }
            }
        }

        fis.close();
        System.out.println(countAlphabet);

    }
}
