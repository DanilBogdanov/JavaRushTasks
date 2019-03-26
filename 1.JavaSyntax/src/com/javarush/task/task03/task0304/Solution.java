package com.javarush.task.task03.task0304;

/* 
Реализуй метод addTenPercent, который увеличивает переданное целое число на 10%.
Исправь ошибку в объявлении метода.

Подсказка:
подумай, какие у этого метода входные и выходные данные.
*/

public class Solution {
    public static double addTenPercent(int i) {
        return i * 1.1;
    }

    public static void main(String[] args) {
        System.out.println(addTenPercent(9));
    }
}
