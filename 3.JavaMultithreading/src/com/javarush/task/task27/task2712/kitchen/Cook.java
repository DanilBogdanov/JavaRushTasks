package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;

public class Cook extends Observable implements Runnable {
    private String name;
    private boolean busy = false;
    private LinkedBlockingQueue<Order> queue;

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    public boolean isBusy() {
        return busy;
    }

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public void startCookingOrder(Order order) {
        busy = true;
        System.out.println("Start cooking - " + order + ", cooking time " + order.getTotalCookingTime() + "min");

        setChanged();
        notifyObservers(order);

        try {
            int delay = order.getTotalCookingTime() * 10;
            Thread.sleep(delay);
        } catch (InterruptedException e) {

        }

        CookedOrderEventDataRow cookedOrderEventDataRow = new CookedOrderEventDataRow(order.getTablet().toString(),
                name, order.getTotalCookingTime(), order.getDishes());
        StatisticManager.getInstance().register(cookedOrderEventDataRow);

        //imitation of delay

        busy = false;
    }

    public void run() {
        try {
            while (true) {
                if (queue.size() > 0) {
                    startCookingOrder(queue.take());

                }
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {

        }
    }


}

