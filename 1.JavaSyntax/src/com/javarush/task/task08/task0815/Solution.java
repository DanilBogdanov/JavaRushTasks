package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Puplin", "Vasya");
        map.put("Pupli", "Petya");
        map.put("Pupln", "Xui");
        map.put("Pupin", "Pizda");
        map.put("Pulin1", "Pidor");
        map.put("Pplin2", "Gandon");
        map.put("Puplin1", "Vasy");
        map.put("Puplin2", "Vasa");
        map.put("Puplin3", "Vsya");
        map.put("Puplin4", "Vya");

        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        int count = 0;

        for (HashMap.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().equals(name)) {
                count++;
            }
        }
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        int count = 0;

        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().equals(lastName)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
    }
}
