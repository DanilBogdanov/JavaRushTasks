package com.javarush.task.task08.task0817;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Нам повторы не нужны
Создать словарь (Map<String, String>) занести в него десять записей по принципу "фамилия" - "имя".
Удалить людей, имеющих одинаковые имена.
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<>();

        map.put("Alegrova", "Alena");
        map.put("Bisketov", "Bashka");
        map.put("Gabidullin", "Gabbas");
        map.put("Dyakinov", "Dmitriy");
        map.put("Evceev", "Evgen");
        map.put("Dgorge", "dgon");
        map.put("Lipnickaya", "Liza");
        map.put("Karlov", "Zed");
        map.put("Zvezdin", "Zed");
        map.put("Javist", "Zed");

        return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        HashSet<String> set = new HashSet<>();

        for (Map.Entry<String, String> entry : map.entrySet()) {
            for (Map.Entry<String, String> entryInner : map.entrySet()) {
                if (entry.getValue().equals(entryInner.getValue()) &&
                        !entry.getKey().equals(entryInner.getKey())) {
                    set.add(entry.getValue());
                }
            }
        }

        set.forEach((element) -> removeItemFromMapByValue(map, element));

    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value) )
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
//        HashMap<String, String> map = createMap();
//        removeTheFirstNameDuplicates(map);
//        map.forEach((family, name) -> System.out.println(family + " " + name));
    }
}
