package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) {
        String strings = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName = reader.readLine();
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            strings = fileReader.readLine();
            //strings = "Киев Нью-Йорк Амстердам Вена тверь ьфывах лисабон Мельбурн Хуй Пизда Мфанда Залупа наг Город Жопа Онал анал Фнал финал Машина Зонт фваз";
        } catch (IOException e) {
            e.printStackTrace();
        }
        //...
        StringBuilder result = getLine(strings.split(" "));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        List<String> strings = new ArrayList<>(Arrays.asList(words));
        List<String> results = new ArrayList<>();

        for (String string : strings) {
            List<String> list = new ArrayList<>(strings);
            list.remove(string);
            String stringRecursive = string;

            results.addAll(recursion(list, stringRecursive));
        }

        int maxLength = 0;
        String stringResult = "";
        for (String string : results) {
            int lengthOfString = string.split(" ").length;
            if (lengthOfString > maxLength) {
                maxLength = lengthOfString;
                stringResult = string;
            }
        }

        return new StringBuilder(stringResult);
    }

    public static List<String> recursion (List<String> strings, String string) {
        List<String> result = new ArrayList<>();

        char lastChar = Character.toLowerCase(string.charAt(string.length() - 1));
        for (String s : strings) {
            char firstChar = Character.toLowerCase(s.charAt(0));
            if (lastChar == firstChar) {
                String stringRecursion = string + " " + s;
                List<String> list = new ArrayList<>(strings);
                list.remove(s);
                if (list.size() == 0) {
                    result.add(stringRecursion);
                } else {
                    result.addAll(recursion(list, stringRecursion));
                }
            }
        }

        if (result.size() == 0) {
            result.add(string);
        }

        return result;
    }

}
