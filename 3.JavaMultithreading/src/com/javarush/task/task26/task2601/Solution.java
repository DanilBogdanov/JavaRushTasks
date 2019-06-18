package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{13, 8, 15, 5, 17};
        sort(array);
    }

    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);
        int mediana = (array.length % 2 == 0) ? (array[array.length / 2] + array[(array.length / 2) - 1]) / 2 : array[array.length / 2];
        Arrays.sort(array, (x, y) -> Integer.compare(Math.abs(mediana - x), Math.abs(mediana - y)));
        return array;
    }
}
