package com.javarush.task.task04.task0426;

/* 
Ввести с клавиатуры целое число. Вывести на экран его строку-описание следующего вида:
"отрицательное четное число" - если число отрицательное и четное,
"отрицательное нечетное число" - если число отрицательное и нечетное,
"ноль" - если число равно 0,
"положительное четное число" - если число положительное и четное,
"положительное нечетное число" - если число положительное и нечетное.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        if (n == 0) {
            System.out.println("ноль");
        } else {
            if (n > 0) {
                System.out.print("положительное ");
            } else {
                System.out.print("отрицательное ");
            }

            if (n % 2 == 0) {
                System.out.println(" четное число");
            } else {
                System.out.println(" нечетное число");
            }
        }
    }
}
