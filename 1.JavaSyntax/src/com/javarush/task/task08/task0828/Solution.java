package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 
Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: "May is the 5 month".
Используйте коллекции.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String month = reader.readLine().toLowerCase();
        ArrayList<String> months = new ArrayList<String>();
        months.add("JANUARY".toLowerCase());
        months.add("FEBRUARY".toLowerCase());
        months.add("MARCH".toLowerCase());
        months.add("APRIL".toLowerCase());
        months.add("MAY".toLowerCase());
        months.add("JUNE".toLowerCase());
        months.add("JULY".toLowerCase());
        months.add("AUGUST".toLowerCase());
        months.add("SEPTEMBER".toLowerCase());
        months.add("OCTOBER".toLowerCase());
        months.add("NOVEMBER".toLowerCase());
        months.add("DECEMBER".toLowerCase());


       for (int i = 0; i < months.size(); i++) {
           if (month.equals(months.get(i))) {
               System.out.printf("%s is the %d month", month.substring(0, 1).toUpperCase()
                       + month.substring(1), i + 1);
           }
       }


    }
}
