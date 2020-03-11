package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private final static int ORDER_CREATING_INTERVAL = 100;
    private final static LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args) {
        List<Tablet> tablets = new ArrayList<>();

        Waiter waiter = new Waiter();

        Cook cook = new Cook("Amigo");
        cook.setQueue(orderQueue);
        cook.addObserver(waiter);
        Thread cookThread = new Thread(cook);
        cookThread.setDaemon(true);
        cookThread.start();

        Cook cook2 = new Cook("Bilabo");
        cook2.setQueue(orderQueue);
        cook2.addObserver(waiter);
        Thread cookThread2 = new Thread(cook2);
        cookThread2.setDaemon(true);
        cookThread2.start();

        for (int i = 0; i < 5; i++) {
            Tablet tablet = new Tablet(i);
            tablet.setQueue(orderQueue);
            tablets.add(tablet);
        }

        RandomOrderGeneratorTask task = new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL);
        Thread thread = new Thread(task);
        thread.start();

        try {
            Thread.sleep(1000);
            thread.interrupt();
        } catch (InterruptedException e) {

        }



        /*

        tablet.addObserver(cook);

        cook.addObserver(waiter);

        tablet.createOrder();
        tablet.createOrder();

        tablet.addObserver(cook2);
        tablet.createOrder();*/


        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printActiveVideoSet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printArchivedVideoSet();
        directorTablet.printCookWorkloading();

    }
}
