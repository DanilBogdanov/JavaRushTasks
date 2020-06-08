package com.javarush.task.task26.task2613;

import java.util.HashMap;
import java.util.Map;

public class CurrencyManipulatorFactory {
    /*2. Валют может быть несколько, поэтому нам понадобится фабрика, которая будет создавать и хранить манипуляторы.
Создай класс CurrencyManipulatorFactory со статическим методом getManipulatorByCurrencyCode(String currencyCode).
В этом методе будем создавать нужный манипулятор, если он еще не существует, либо возвращать ранее созданный.
Регистр при поиске манипулятора валюты не должен учитываться.
Подумай, где лучше хранить все манипуляторы? Маленькая подсказка, поле должно называться map.

Сделайте так, чтобы невозможно было создавать объекты CurrencyManipulatorFactory класса.
    * */
    private CurrencyManipulatorFactory(){}

    private static Map<String, CurrencyManipulator> map = new HashMap<>();

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        currencyCode = currencyCode.toLowerCase();
        if (map.containsKey(currencyCode)) {
            return map.get(currencyCode);
        } else {
            CurrencyManipulator manipulator = new CurrencyManipulator(currencyCode);
            map.put(currencyCode, manipulator);
            return manipulator;
        }
    }
}
