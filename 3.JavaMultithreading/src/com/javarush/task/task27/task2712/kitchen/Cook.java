package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable implements Observer {
    private String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public void update(Observable observable, Object arg) {
        Order order = (Order) arg;
        System.out.println("Start cooking - " + arg + ", cooking time " + order.getTotalCookingTime() + "min");

        setChanged();
        notifyObservers(arg);

        CookedOrderEventDataRow cookedOrderEventDataRow = new CookedOrderEventDataRow(order.getTablet().toString(),
                name, order.getTotalCookingTime(), order.getDishes());
        StatisticManager.getInstance().register(cookedOrderEventDataRow);
    }
}
