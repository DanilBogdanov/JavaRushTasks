package com.javarush.task.task03.task0309;

/* 
Сумма 10 чисел
*/

public class Solution {
    public static void main(String[] args) {
        int res = 0;
        for (int i = 1; i <= 10; i++) {
            res += i;
            System.out.println(res);
        }
    }
}
