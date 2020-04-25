package com.javarush.task.task31.task3105;

import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        byte [] first = new byte[Integer.MAX_VALUE / 2];
        //byte [] second = new byte[Integer.MAX_VALUE];

        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
