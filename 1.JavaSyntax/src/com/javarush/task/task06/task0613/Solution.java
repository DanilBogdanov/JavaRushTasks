package com.javarush.task.task06.task0613;

/* 
В классе Cat создай статическую переменную public int catCount.
Создай конструктор [public Cat()]. Пусть при каждом создании кота (нового объекта Cat) статическая переменная catCount увеличивается на 1. Создать 10 объектов Cat и вывести значение переменной catCount на экран.
*/

public class Solution {
    public static void main(String[] args) {
        //создай 10 котов
        for (int i = 0; i < 10; i++) {
            new Cat();
        }

        System.out.println(Cat.catCount);

        //выведи значение переменной catCount
    }

    public static class Cat {
        public static int catCount = 0;

        public Cat() {
            catCount++;
        }

        //создай конструктор
    }
}
