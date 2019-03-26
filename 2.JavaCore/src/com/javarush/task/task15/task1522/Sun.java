package com.javarush.task.task15.task1522;

/**
 * Created by Данил on 01.08.2018.
 */
public class Sun implements Planet {
    private static Sun instance;

    private Sun() {}

    public static Sun getInstance() {
        if (instance == null) {
            instance = new Sun();
        }

        return instance;
    }
}
