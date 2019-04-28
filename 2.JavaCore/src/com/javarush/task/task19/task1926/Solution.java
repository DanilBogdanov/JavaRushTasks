package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName = reader.readLine();
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            while (fileReader.ready()) {
                String line = fileReader.readLine();
                String result = "";
                for (int i = line.length() - 1 ; i >= 0; i--) {
                    result += line.charAt(i);
                }
                System.out.println(result);
            }
            fileReader.close();
        } catch (IOException e) {

        }

    }
}
