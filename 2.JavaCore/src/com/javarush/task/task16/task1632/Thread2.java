package com.javarush.task.task16.task1632;

/**
 * Created by Данил on 06.08.2018.
 */
public class Thread2 extends Thread {
    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
    }
}
