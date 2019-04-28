package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        //args = new String[]{"d:/1.txt", "d:/2.txt"};
        start(args);
    }

    private static void start(String[] args) {
        String firstFileName = args[0];
        String secondFileName = args[1];
        String result = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(firstFileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(secondFileName))) {

            while (reader.ready()) {
                String[] line = reader.readLine().split(" ");
                for (String word : line) {
                    if (word.length() > 6) {
                        result += word + ",";
                    }
                }
            }

            if (result.length() > 0) {
                result = result.substring(0, result.length() - 1);
            }
            writer.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
