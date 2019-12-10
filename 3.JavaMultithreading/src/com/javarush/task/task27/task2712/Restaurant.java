package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;

public class Restaurant {
    public static void main(String[] args) {
        Tablet tablet = new Tablet(0);

//todo remove in Order and VideoSelectedEventDataRow

        Cook cook = new Cook("Amigo");
        Cook cook2 = new Cook("Bilabo");
        Waiter waiter = new Waiter();

        tablet.addObserver(cook);

        cook.addObserver(waiter);

        tablet.createOrder();
        tablet.createOrder();

        tablet.addObserver(cook2);
        tablet.createOrder();


        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printActiveVideoSet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printArchivedVideoSet();
        directorTablet.printCookWorkloading();

    }
}
