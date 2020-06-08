package com.javarush.task.task26.task2613;

import java.util.Map;

public class CurrencyManipulator {
    /*1.1 String currencyCode - код валюты, например, USD. Состоит из трех букв.
1.2 Map<Integer, Integer> denominations - это Map<номинал, количество>.
Чтобы можно было посмотреть, к какой валюте относится манипулятор, добавим геттер для currencyCode.
Очевидно, что манипулятор никак не может функционировать без названия валюты, поэтому добавим конструктор с этим параметром и проинициализируем currencyCode.

2. Валют может быть несколько, поэтому нам понадобится фабрика, которая будет создавать и хранить манипуляторы.
Создай класс CurrencyManipulatorFactory со статическим методом getManipulatorByCurrencyCode(String currencyCode).
В этом методе будем создавать нужный манипулятор, если он еще не существует, либо возвращать ранее созданный.
Регистр при поиске манипулятора валюты не должен учитываться.
Подумай, где лучше хранить все манипуляторы? Маленькая подсказка, поле должно называться map.

Сделайте так, чтобы невозможно было создавать объекты CurrencyManipulatorFactory класса.

*/
    private String currencyCode;
    private Map<Integer, Integer> denominations;

    public String getCurrencyCode() {
        return currencyCode;
    }

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
