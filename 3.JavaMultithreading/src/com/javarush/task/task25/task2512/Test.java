package com.javarush.task.task25.task2512;

public class Test {
    public static void main(String[] args) throws Exception {
        Thread thread = new Thread();
        thread.wait();
        Object o  = new Object();
        o.wait();

    }


}
