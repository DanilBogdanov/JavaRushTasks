package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
Среднее арифметическое
Вводить с клавиатуры числа и вычислить среднее арифметическое.
Если пользователь ввел -1, вывести на экран среднее арифметическое всех чисел и завершить программу.
-1 не должно учитываться.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int buffer;
        int summ = 0;
        int count = 0;

        while((buffer = Integer.parseInt(reader.readLine())) != -1) {
            count++;
            summ += buffer;
        }

        System.out.println(count == 0 ? 0 : (double)summ / count);
    }
}

