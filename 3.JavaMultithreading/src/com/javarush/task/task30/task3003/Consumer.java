package com.javarush.task.task30.task3003;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

public class Consumer implements Runnable {
    TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(450);
                while (true) {
                    ShareItem item = queue.take();
                    System.out.format("Processing %s%n", item.toString());
                }
            } catch (InterruptedException e) {
                return;
            }


        }
    }
}
