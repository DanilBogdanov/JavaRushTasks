package com.javarush.task.task16.task1632;

/**
 * Created by Данил on 06.08.2018.
 */
public class Thread3 extends Thread {
    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Ура");
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {

        }
    }


}
