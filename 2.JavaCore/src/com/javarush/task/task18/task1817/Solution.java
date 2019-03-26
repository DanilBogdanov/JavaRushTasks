package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;

public class Solution {
    public static void main(String[] args) throws IOException {
         //args = new String []{"D:/1.txt"};
        int spaces = 0;
        int simbols = 0;
        try (FileInputStream fis = new FileInputStream(args[0])) {
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            simbols = buffer.length;
            for (byte ch : buffer) {
           //     System.out.println(ch + " " + (char) ch);
                if (' ' == ch) {
                    spaces++;
                }
            }
        }

        //System.out.println("spaces " + spaces);
        //System.out.println("simbols " + simbols);
        double result = ((spaces * 1.0 / simbols) * 100);
        //System.out.println("result before of round " + result);
        result = (Math.round(result * 100)) / 100.0;
        System.out.println(result);

    }
}
