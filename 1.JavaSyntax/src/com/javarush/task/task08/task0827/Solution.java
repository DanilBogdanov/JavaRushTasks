package com.javarush.task.task08.task0827;

import java.util.Date;

/* 
Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате FEBRUARY 1 2013
Не забудьте учесть первый день года.
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) {
        long timeInDay = 1000 * 60 * 60 * 24;
        Date date1 = new Date(date);
        Date dateYear = new Date();

        dateYear.setYear(date1.getYear());
        dateYear.setMonth(0);
        dateYear.setDate(1);
        dateYear.setHours(0);
        dateYear.setMinutes(0);
        dateYear.setSeconds(0);
        int dayFromNewYear = (int) ((date1.getTime() - dateYear.getTime()) / timeInDay);

        return dayFromNewYear % 2 != 0;
    }
}
