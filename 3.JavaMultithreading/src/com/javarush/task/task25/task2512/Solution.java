package com.javarush.task.task25.task2512;

import java.util.ArrayList;
/* 
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();

        ArrayList<Throwable> throwables = new ArrayList<>();
        throwables.add(e);
        Throwable cause = e.getCause();

        while (cause != null) {
            throwables.add(cause);
            cause = cause.getCause();
        }

        for (int i = throwables.size() - 1; i >= 0; i--) {
            Throwable throwable = throwables.get(i);
            System.out.printf("%s: %s\n", throwable.getClass().getName(), throwable.getMessage());
        }


    }

    public static void main(String[] args) {
        Exception exception = new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
        new Solution().uncaughtException(Thread.currentThread(), exception);
    }
}
