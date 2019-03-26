package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

/* 
Добрая Зинаида и летние каникулы
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: "фамилия" - "дата рождения".
Удалить из словаря всех людей, родившихся летом.


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Метод createMap() должен создавать и возвращать словарь HashMap с типом элементов String, Date состоящий из 10 записей.
4. Метод removeAllSummerPeople() должен удалять из словаря всех людей, родившихся летом.
*/

public class Solution {
    public static HashMap<String, Date> createMap() throws ParseException {

        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone",new Date());
        map.put("Sigurtni",new Date());
        map.put("Sigurtn", new Date());
        map.put("Sigurti", new Date());
        map.put("Sigurni", new Date());
        map.put("Sigutni", new Date());
        map.put("Sigrtni", new Date());
        map.put("Siurtni", new Date());
        map.put("Sgurtni", new Date());
        map.put("igurtni", new Date());

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        map.forEach((name, date) -> {
            if (date.getMonth() > 4 && date.getMonth() < 8) {
                map.remove(name);
            }
        });


    }

    public static void main(String[] args) {

//        try {
//            HashMap<String, Date> map = createMap();
//            //removeAllSummerPeople(map);
//            map.forEach((name, date) -> System.out.println(name + " " + date));
//        } catch (Exception e) {
//
//        }
    }
}
