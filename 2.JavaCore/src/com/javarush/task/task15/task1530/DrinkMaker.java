package com.javarush.task.task15.task1530;

/**
 * Created by Данил on 02.08.2018.
 * 1. В отдельном файле создать класс DrinkMaker с тремя абстрактными методами:
 - void getRightCup() - выбрать подходящую чашку
 - void putIngredient() - положить ингредиенты
 - void pour() - залить жидкостью
 2. В классе DrinkMaker создать и реализовать метод void makeDrink(), который готовит напиток в такой последовательности: выбирает чашку, кладет ингредиенты, заливает жидкостью.
 3. В отдельных файлах создать классы LatteMaker и TeaMaker, которые наследуются от DrinkMaker.
 4. Распредели следующие фразы между всеми методами в классах LatteMaker и TeaMaker, различные фразы для различных методов.
 5. Каждый метод должен выводить в консоль свою фразу не пересекаясь с другими методами.
 */
public abstract class DrinkMaker {
    abstract protected void getRightCup();
    abstract protected void putIngredient();
    abstract protected void pour();

    void makeDrink() {
        getRightCup();
        putIngredient();
        pour();
    }
}
