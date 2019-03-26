package com.javarush.task.task08.task0813;

import java.util.Set;
import java.util.HashSet;

/* 
20 слов на букву «Л»
*/

public class Solution {
    public static Set<String> createSet() {
        Set<String> set = new HashSet<>();
        String[] words = {"а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и", "к", "л", "м", "н", "о",
                "п", "р", "с", "т", "у"};
        for (int i = 0; i < 20; i++) {
            set.add("Л" + words[i]);
        }

        return set;
    }

    public static void main(String[] args) {

    }
}
