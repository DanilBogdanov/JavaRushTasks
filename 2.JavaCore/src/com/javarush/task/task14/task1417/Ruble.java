package com.javarush.task.task14.task1417;

/**
 * Created by Администратор on 30.07.2018.
 */
public class Ruble extends Money {
    public Ruble (double amount) {
        super(amount);
    }

    @Override
    public String getCurrencyName() {
        return "RUB";
    }

}
