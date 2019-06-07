package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    Thread thread;
    State state;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
        setDaemon(true);

    }

    @Override
    public void run() {
        while(state != State.TERMINATED) {
            if (thread.getState() != state) {
                state = thread.getState();
                System.out.println(state);
            }
        }
    }
}
