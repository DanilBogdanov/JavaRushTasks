package com.javarush.task.task09.task0919;

/* 
Создай метод public static void divisionByZero, в котором подели любое число на ноль и выведи на экран результат деления.
Оберни вызов метода divisionByZero в try..catch. Выведи стек-трейс исключения используя метод exception.printStackTrace()


Деление на ноль
*/

public class Solution {

    public static void main(String[] args) {
        try {
        divisionByZero(); } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void divisionByZero() {
        int a = 10;
        int b = 0;
        System.out.println(a / 0);

    }
}
