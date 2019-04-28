package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Solution {
    public static void main(String[] args) {
        //args = new String[]{"D:/1.txt"};
        start(args);
    }

    public static void start(String[] args) {
        String fileName = args[0];
        getMaxOfMap(readFileToMap(fileName)).forEach((person) -> System.out.println(person));
    }

    public static ArrayList<String> getMaxOfMap(Map<String, Double> map) {
        double maxCount = 0;
        ArrayList<String> maxPerson = new ArrayList<>();

        for (Map.Entry<String, Double> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxPerson.clear();
                maxCount = entry.getValue();
                maxPerson.add(entry.getKey());
            } else if (entry.getValue() == maxCount){
                maxPerson.add(entry.getKey());
            }
        }

        Collections.sort(maxPerson);

        return maxPerson;
    }

    public static Map<String, Double> readFileToMap(String fileName) {
        HashMap<String, Double> people = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String[] line;
            String person;
            Double value;

            while (reader.ready()) {
                line = reader.readLine().split(" ");
                person = line[0];
                value = Double.parseDouble(line[1]);

                if (people.containsKey(person))
                    value = people.get(person) + value;

                people.put(person, value);
            }
        } catch (IOException e) {

        }
        return people;
    }
}
