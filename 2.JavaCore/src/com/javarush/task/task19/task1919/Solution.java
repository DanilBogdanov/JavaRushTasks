package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        start(args);
    }

    public static void start(String[] args) {
        String fileName = args[0];

        Map<String, Double> map = readFileToMap(fileName);

        map.forEach((k, m) -> System.out.println(k + " " + m));
    }

    public static Map<String, Double> readFileToMap(String fileName) {
        TreeMap<String, Double> resMap = new TreeMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                String[] line = reader.readLine().split(" ");
                String familyName = line[0];
                Double count = Double.parseDouble(line[1]);

                if (resMap.containsKey(familyName)) {
                    resMap.put(familyName, resMap.get(familyName) + count);
                } else {
                    resMap.put(familyName, count);
                }
            }
        } catch (IOException e) {

        }
        return resMap;
    }
}
