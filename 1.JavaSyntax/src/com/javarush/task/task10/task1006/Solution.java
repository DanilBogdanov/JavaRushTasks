package com.javarush.task.task10.task1006;

/* 
Задача №6 на преобразование целых типов
Убери ненужные операторы приведения типа, чтобы получился ответ: result: 1000.0
double d = (short) 2.50256e2d;
char c = (short) 'd';
short s = (short) 2.22;
int i = (short) 150000;
float f = (short) 0.50f;
double result = f + (i / c) - (d * s) - 500e-3;
*/

public class Solution {
    public static void main(String[] args) {
        double d = (short) 2.50256e2d; // 250.0
        char c = (short) 'd'; //
        short s = (short) 2.22; // 2
        int i = (int) 150000; // 18928
        float f =  0.50f; //0.0
        double result = f + (i / c) - (d * s) - 500e-3;  // -311.5
        System.out.println("result: " + result);

    }
}