package com.javarush.task.task15.task1516;

/* 
Значения по умолчанию
*/

import java.lang.reflect.Field;

public class Solution {
    int intVar;
    double doubleVar;
    Double DoubleVar;
    boolean booleanVar;
    Object ObjectVar;
    Exception ExceptionVar;
    String StringVar;

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        for (Field field : solution.getClass().getDeclaredFields()) {
            System.out.println(field.get(solution));
        }


    }
}
