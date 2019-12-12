package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;

import java.util.ArrayList;
import java.util.Date;

public class Restaurant {
    public static void main(String[] args) {
        Tablet tablet = new Tablet(0);

//todo remove in Order and VideoSelectedEventDataRow

        Cook cook = new Cook("Amigo");
        Cook cook2 = new Cook("Bilabo");

        CookedOrderEventDataRow ev1 = new CookedOrderEventDataRow("t1", "Cook1", 958, new ArrayList<>());
        CookedOrderEventDataRow ev2 = new CookedOrderEventDataRow("t1", "Cook2", 23, new ArrayList<>());
        CookedOrderEventDataRow ev3 = new CookedOrderEventDataRow("t1", "Cook3", 654, new ArrayList<>());
        CookedOrderEventDataRow ev4 = new CookedOrderEventDataRow("t1", "Cook1", 12, new ArrayList<>());
        CookedOrderEventDataRow ev5 = new CookedOrderEventDataRow("t1", "Cook2", 555, new ArrayList<>());

        Date date1 = new Date();
        date1.setTime(date1.getTime() + ((int)Math.random() * 1000 * 60 * 60 * 24 *30));

        date1.setDate(34);
        Date date2 = new Date();
        date2.setTime(date2.getTime() + ((int)Math.random() * 1000 * 60 * 60 * 24 *30));

        System.out.println(date1);
        System.out.println(date2);

        ev1.setDate(date1);
        ev2.setDate(date1);
        ev3.setDate(date1);
        ev4.setDate(date2);
        ev5.setDate(date2);

        StatisticManager.getInstance().register(ev1);
        StatisticManager.getInstance().register(ev2);
        StatisticManager.getInstance().register(ev3);
        StatisticManager.getInstance().register(ev4);
        StatisticManager.getInstance().register(ev5);


        /*Waiter waiter = new Waiter();

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
