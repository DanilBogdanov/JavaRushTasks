package com.javarush.task.task14.task1419;

import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            File flle = new File("C:\\1.txtttt");
            InputStreamReader reader = new FileReader(flle);
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            int[] i = new int[1];
            i[10] = 1;
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            String s = null;
            System.out.println(s.equals("sdf"));
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            String s = "adf";
            Integer.parseInt(s);
        } catch (Exception e) {
            exceptions.add(e);
        }

        exceptions.add(new MyExc1());
        exceptions.add(new MyExc2());
        exceptions.add(new MyExc3());
        exceptions.add(new MyExc4());
        exceptions.add(new MyExc5());

    }

    private static class MyExc1 extends Exception {}
    private static class MyExc2 extends Exception {}
    private static class MyExc3 extends Exception {}
    private static class MyExc4 extends Exception {}
    private static class MyExc5 extends Exception {}
}
