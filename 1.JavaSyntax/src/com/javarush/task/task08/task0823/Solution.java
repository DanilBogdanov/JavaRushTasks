package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        char[] sArray = s.toCharArray();

        for (int i = 0; i < sArray.length; i++) {
            if ((i == 0 && sArray[0] != ' ') || (i != 0 && sArray[i] != ' ' && sArray[i - 1] == ' ')) {
                sArray[i] = Character.toUpperCase(sArray[i]);
            }
            System.out.print(sArray[i]);
        }
    }
}
