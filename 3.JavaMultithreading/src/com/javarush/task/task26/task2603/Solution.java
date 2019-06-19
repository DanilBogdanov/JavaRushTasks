package com.javarush.task.task26.task2603;

/* 
Убежденному убеждать других не трудно
*/

import java.util.Comparator;

public class Solution {


    public static void main(String[] args) {

    }

    public static class CustomizedComparator<T> implements Comparator<T> {
        private Comparator <T>[] comparators;

        public CustomizedComparator(Comparator<T> ... comparators) {
            this.comparators = comparators;
        }

        public int compare(T solution, T solution1) {
            int result = 0;
            for (Comparator comp : comparators) {
                result = comp.compare(solution, solution1);
                if (result != 0) return result;
            }

            return result;
        }
    }
}
