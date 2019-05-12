package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null) return false;
        String numbers = telNumber.replaceAll("\\D", "");
        if (numbers.length() == 12) {
            return telNumber.matches("^\\+\\d*(\\(\\d{3}\\))*\\d*-?\\d+-?\\d+$");
        } else if (numbers.length() == 10) {
            return telNumber.matches("^\\d*(\\(\\d{3}\\))*\\d*-?\\d+-?\\d+$");
        }
        return false;
    }

    public static void main(String[] args) {
        String num = "+380501234567\n" +
                "+38(050)1234567\n" +
                "+38050123-45-67\n" +
                "050123-4567\n" +
                "+38)050(1234567\n" +
                "+38(050)1-23-45-6-7\n" +
                "050ххх4567\n" +
                "050123456\n" +
                "(0)501234567";
        for (String s : num.split("\n")) {
            System.out.println(s + " - " + checkTelNumber(s));
        }

    }
}
