package com.javarush.task.task27.task2712.kitchen;

public enum Dish {
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    Dish(int duration) {
        this.duration = duration;
    }

    private int duration;

    public int getDuration() {
        return duration;
    }

    public static String allDishesToString() {
        String result = "";
        for (Dish dish : Dish.values()) {
            result += dish + ", ";
        }
        if (result.length() > 2) {
            result = result.substring(0, result.length() - 2);
        }
        return result;
    }


}
