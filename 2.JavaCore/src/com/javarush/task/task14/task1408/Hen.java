package com.javarush.task.task14.task1408;

/**
 * Created by Данил on 30.07.2018.
 */
abstract class Hen {
    abstract int getCountOfEggsPerMonth();

    String getDescription() {
        return "Я - курица.";
    }
}
