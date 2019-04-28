package com.javarush.task.task04.task0442;


/* 
Вводить с клавиатуры числа.
Если пользователь ввел -1, вывести на экран сумму всех введенных чисел и завершить программу.
-1 должно учитываться в сумме.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int i = 0;
        int summ = 0;

        while (true) {
            i = Integer.parseInt(reader.readLine());
            summ += i;
            if (-1 == i) break;
        }

        System.out.println(summ);
    }
}
