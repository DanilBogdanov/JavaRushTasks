package com.javarush.task.task15.task1522;

/**
 * Created by Данил on 01.08.2018.
 */
public class Moon implements Planet {
    private static Moon instance;

    private Moon() {}

    public static Moon getInstance() {
        if (instance == null) {
            instance = new Moon();
        }
        return instance;
    }
}
