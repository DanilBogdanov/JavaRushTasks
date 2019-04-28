package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        String result = "";
        try {
           if ((string.length() - string.replace("\t", "").length()) < 2) throw new RuntimeException();
           int firstIndex = string.indexOf("\t");
           int lastIndex = string.indexOf("\t", firstIndex + 1);
           result = string.substring(firstIndex + 1, lastIndex);
        } catch (Exception e) {
            throw new TooShortStringException();
        }
        return result;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {

        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }

    public static  void test () {
        String test = "1111\t22222\t3";
        System.out.println("length:" + test.split("\t").length);
        int count = test.length() - test.replace("\t", "").length();
        System.out.println("count:" + count);
        for (String s : test.split("\t")) {
            System.out.println(">>" + s + "<<");
        }
    }
}
