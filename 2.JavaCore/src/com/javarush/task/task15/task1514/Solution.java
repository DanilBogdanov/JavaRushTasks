package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static {
        labels.put(123d, "adf");
        labels.put(1233d, "adsf");
        labels.put(1234d, "adff");
        labels.put(1236d, "adhf");
        labels.put(1283d, "aadf");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
