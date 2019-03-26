package com.javarush.task.task07.task0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
1. Создать массив на 10 чисел.
2. Ввести с клавиатуры 10 чисел и записать их в массив.
3. Вывести на экран элементы массива в обратном порядке, каждое значение выводить с новой строки.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] nArray = new int[10];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < nArray.length; i++) {
            nArray[i] = Integer.parseInt(reader.readLine());
        }

        for (int i = 0; i < nArray.length; i++) {
            System.out.println(nArray[nArray.length - i - 1]);
        }
    }
}

