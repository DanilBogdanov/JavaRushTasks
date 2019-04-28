package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() {
        //implement this method - реализуйте этот метод
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            FileInputStream fis = new FileInputStream(reader.readLine());
            this.load(fis);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties propertiesSave = new Properties();
        propertiesSave.putAll(properties);
        propertiesSave.store(outputStream, "properties");


    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties propertiesLoad = new Properties();
        propertiesLoad.load(inputStream);
        propertiesLoad.forEach((k, v) -> properties.put((String)k, (String)v));
    }

    public static void main(String[] args) throws Exception {
        properties.put("first", "sesdfsdfcond");
        properties.put("last", "lost");
        Solution solution = new Solution();
        solution.save(new FileOutputStream("D:/1.properties"));
    }
}
