package com.javarush.task.task16.task1632;

/**
 * Created by Данил on 06.08.2018.
 */
public class Thread4 extends Thread implements Message {
    @Override
    public void showWarning() {
        if (this.isAlive()) {
            this.interrupt();
        }
    }

    @Override
    public void run() {
        while (!isInterrupted()) {

        }
    }
}
