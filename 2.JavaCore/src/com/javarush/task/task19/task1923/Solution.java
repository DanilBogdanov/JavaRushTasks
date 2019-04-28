package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        start(args);
    }

    public static void start(String[] args) {
        String firstFileName = args[0];
        String secondFileName = args[1];

        try (BufferedReader fileReader = new BufferedReader(new FileReader(firstFileName));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter(secondFileName))) {
            String result = "";
            String line[];

            while (fileReader.ready()) {
                line = fileReader.readLine().split(" ");
                Pattern pattern = Pattern.compile("\\d");
                for (String string : line) {
                    Matcher matcher = pattern.matcher(string);
                    if (matcher.find()) {
                        result += string + " ";
                    }
                }
            }

            fileWriter.write(result);
        } catch (IOException e) {

        }
    }
}
