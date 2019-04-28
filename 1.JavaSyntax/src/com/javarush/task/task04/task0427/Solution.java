package com.javarush.task.task04.task0427;

/* 
Ввести с клавиатуры целое число в диапазоне 1 - 999. Вывести его строку-описание следующего вида:
"четное однозначное число" - если число четное и имеет одну цифру,
"нечетное однозначное число" - если число нечетное и имеет одну цифру,
"четное двузначное число" - если число четное и имеет две цифры,
"нечетное двузначное число" - если число нечетное и имеет две цифры,
"четное трехзначное число" - если число четное и имеет три цифры,
"нечетное трехзначное число" - если число нечетное и имеет три цифры.
Если введенное число не попадает в диапазон 1 - 999, в таком случае ничего не выводить на экран.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int len = s.length();
        int n = Integer.parseInt(s);

        if (n >= 1 && n <= 999) {
            if (n % 2 == 0) {
                System.out.print("четное ");
            } else {
                System.out.print("нечетное ");
            }

            if (len == 1) System.out.println("однозначное число");
            if (len == 2) System.out.println("двузначное число");
            if (len == 3) System.out.println("трехзначное число");
        }

    }
}
