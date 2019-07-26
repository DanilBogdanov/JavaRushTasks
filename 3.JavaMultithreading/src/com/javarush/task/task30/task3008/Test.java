package com.javarush.task.task30.task3008;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Test {
    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("d.MM.YYYY");
        System.out.println(sdf.format(calendar.getTime()));

        System.out.println(calendar.getTime());
    }
}
