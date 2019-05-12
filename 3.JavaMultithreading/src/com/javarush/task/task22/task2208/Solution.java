package com.javarush.task.task22.task2208;

import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {

    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder result = new StringBuilder();

        for (Map.Entry entry : params.entrySet()) {
            if (entry.getValue() != null) {
                if (result.length() > 0) {
                    result = result.append(" and ");
                }
                result.append(String.format("%s = '%s'", entry.getKey(), entry.getValue()));
            }
        }

        return result.toString();
    }
}
