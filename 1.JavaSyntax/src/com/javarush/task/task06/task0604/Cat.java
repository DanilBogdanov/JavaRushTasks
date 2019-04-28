package com.javarush.task.task06.task0604;

/* 
В конструкторе класса Cat [public Cat()] увеличивать счётчик котов (статическую переменную этого же класса catCount) на 1. В методе finalize уменьшать на 1.
Ставим котов на счётчик
*/

public class Cat {
    public static int catCount = 0;

    //напишите тут ваш код
    public Cat() {
        catCount++;
    }

    protected void finalize() throws Throwable {
        catCount--;
    }

    public static void main(String[] args) {

    }
}