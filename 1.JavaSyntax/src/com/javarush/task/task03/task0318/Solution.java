package com.javarush.task.task03.task0318;

/* 
План по захвату мира
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int year = Integer.parseInt(reader.readLine());
        String name = reader.readLine();

        System.out.printf("%s захватит мир через %d лет. Му-ха-ха!", name, year);
    }
}
