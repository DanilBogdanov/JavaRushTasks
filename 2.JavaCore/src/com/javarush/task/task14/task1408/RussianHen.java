package com.javarush.task.task14.task1408;

/**
 * Created by Данил on 30.07.2018.
 */
public class RussianHen extends Hen{
    @Override
    public int getCountOfEggsPerMonth() {
        return 12;
    }

    @Override
    public String getDescription() {
        return super.getDescription() +
                String.format(" Моя страна - %s. Я несу %d яиц в месяц.", Country.RUSSIA, getCountOfEggsPerMonth());
    }
}
