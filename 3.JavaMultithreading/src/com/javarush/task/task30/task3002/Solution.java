package com.javarush.task.task30.task3002;

import java.math.BigInteger;

/*
Осваиваем методы класса Integer
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        if (s.startsWith("0x")) {
            return Integer.parseInt(s.substring(2), 16) + "";
        }
        if (s.startsWith("0b")) {
            return Integer.parseInt(s.substring(2), 2) + "";
        }
        if (s.startsWith("0")) {
            return Integer.parseInt(s.substring(1), 8) + "";
        }
int i = 030;
        return Integer.parseInt(s, 10) + "";
    }
}
