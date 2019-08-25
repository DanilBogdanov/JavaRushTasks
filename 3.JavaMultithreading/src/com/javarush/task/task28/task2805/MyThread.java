package com.javarush.task.task28.task2805;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class MyThread extends Thread {
    private static int priority = 0;

    {
        priority++;


        if (priority > MAX_PRIORITY) {
            priority = MIN_PRIORITY;
        }
        this.setPriority(priority);
        System.out.println("in block");
    }



    public MyThread() {
        super();
        System.out.println("in constructor ");
    }

    public MyThread(Runnable target) {
        super(target);

    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);

    }

    public MyThread(String name) {
        super(name);

    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);

    }

    public MyThread(Runnable target, String name) {
        super(target, name);

    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);

    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);

    }


}
