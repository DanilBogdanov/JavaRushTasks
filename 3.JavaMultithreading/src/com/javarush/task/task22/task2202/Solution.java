package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        String result = "";
        try {
            int index = string.indexOf(" ");

            int lastIndex = string.indexOf(" ", index + 1);
            lastIndex = string.indexOf(" ", lastIndex + 1);
            lastIndex = string.indexOf(" ", lastIndex + 1);
            if (index == -1 || lastIndex == -1) throw new RuntimeException();
            lastIndex = (string.indexOf(" ", lastIndex + 1) == -1) ? string.length()  : string.indexOf(" ", lastIndex + 1);
            result =  string.substring(index + 1, lastIndex);
        } catch (RuntimeException e) {
            throw new TooShortStringException();
        }
        return result;
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
