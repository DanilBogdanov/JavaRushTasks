package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;

public class Restaurant {
    public static void main(String[] args) {
        Tablet tablet = new Tablet(0);
        Cook cook = new Cook("Amigo");
        tablet.addObserver(cook);

        tablet.createOrder();

    }
}
