package com.javarush.task.task18.task1821;

import java.io.FileInputStream;
import java.io.IOException;
/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) {
        //args = new String [] {"D:/1.txt"};

        try (FileInputStream fis = new FileInputStream(args[0])) {
            int[] symbols = new int[256];
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);

            for (byte symbol : buffer) {
                symbols[symbol]++;
            }

            for (int i = 0; i < symbols.length; i++) {
                if (symbols[i] != 0) {
                    System.out.println((char) i + " " + symbols[i]);
                }
            }


        } catch (IOException e) {

        }
    }
}
