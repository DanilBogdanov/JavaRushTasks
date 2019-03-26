package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        HashMap<String, Integer> map = new HashMap<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int id;
        String name;
        String buffer;

        while (!"".equals(buffer = reader.readLine())) {
            id = Integer.parseInt(buffer);
            name = reader.readLine();
            System.out.println(id + " " + name);
            map.put(name, id);
        }

        for (Map.Entry entry : map.entrySet()) {


        }


    }
}
