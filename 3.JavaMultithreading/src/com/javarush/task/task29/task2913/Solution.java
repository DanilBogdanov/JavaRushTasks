package com.javarush.task.task29.task2913;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b) {
        String result = "";
        if (a < b) {
            for (int i = a; i <= b; i++) {
                result = result + (i + " ");
                //result.append(" ");
            }
        } else {
            for (int i = a; i >= b; i--) {
                result = result +  (i + " ");
                //result.append(" ");
            }
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        BigDecimal val = BigDecimal.valueOf(123);

        Random random = new Random();
        numberA = 0;
        numberB = 100000;
        Date date = new Date();
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println("time is : " + (new Date().getTime() - date.getTime()));
        date = new Date();
        System.out.println("\n\n" + getAllNumbersBetween(numberB, numberA));
        System.out.println("time is : " + (new Date().getTime() - date.getTime()));

    }
}