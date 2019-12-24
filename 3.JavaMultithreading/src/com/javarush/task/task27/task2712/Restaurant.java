package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;

    public static void main(String[] args) {
        List<Tablet> tablets = new ArrayList<>();
        OrderManager orderManager = new OrderManager();

        Waiter waiter = new Waiter();

        Cook cook = new Cook("Amigo");
        cook.addObserver(waiter);
        Cook cook2 = new Cook("Bilabo");
        cook2.addObserver(waiter);

        for (int i = 0; i < 5; i++) {
            Tablet tablet = new Tablet(i);
            tablet.addObserver(orderManager);
            tablets.add(tablet);
        }

        StatisticManager.getInstance().register(cook);
        StatisticManager.getInstance().register(cook2);

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
