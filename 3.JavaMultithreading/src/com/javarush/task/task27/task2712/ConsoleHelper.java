package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        writeMessage(Dish.allDishesToString());
        writeMessage("please get order");
        List<Dish> order = new ArrayList<>();

        while (true) {
            String line = readString();
            if ("exit".equals(line)) {
                break;
            } else {
                Dish dishToOrder = null;

                for (Dish dish : Dish.values()) {
                    if (dish.name().equals(line)) {
                        dishToOrder = dish;
                        break;
                    }
                }

                if (dishToOrder != null) {
                    order.add(dishToOrder);
                } else {
                    writeMessage("try again");
                }
            }
        }

        return order;
    }

    public static void main(String[] a) {
        try {
            System.out.println(getAllDishesForOrder());

        } catch (IOException e ) {

        }
    }
}
