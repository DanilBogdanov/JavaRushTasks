package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable {
    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        try {
            int count = 1;
            while (true) {
                map.put(String.valueOf(count), String.format("Some text for %s", count));
                count++;
                Thread.sleep(500);
            }

        } catch (Exception e) {
            System.out.printf("[%s] thread was terminated", Thread.currentThread().getName());
        }

    }
}
