package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        int maxBite = 0;
        int buffer;

        while(fis.available() > 0) {
            buffer = fis.read();
            maxBite = buffer > maxBite ? buffer : maxBite;
        }

        System.out.println(maxBite);

        fis.close();

    }
}
