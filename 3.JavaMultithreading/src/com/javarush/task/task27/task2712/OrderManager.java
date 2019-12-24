package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class OrderManager implements Observer {
    private LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

    @Override
    public void update(Observable o, Object arg) {
        Order order = (Order) arg;
        orderQueue.offer(order);
    }

    public OrderManager() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {
                        if (orderQueue.size() > 0) {
                            Set<Cook> cookSet = StatisticManager.getInstance().getCooks();
                            for (Cook cook : cookSet) {
                                if (!cook.isBusy()) {
                                    cook.startCookingOrder(orderQueue.take());
                                }
                                if (orderQueue.isEmpty()) {
                                    break;
                                }
                            }
                        }
                        Thread.sleep(10);
                    }
                } catch (InterruptedException e) {

                }
            }
        };
        thread.setDaemon(true);
        thread.start();
    }
}
