package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Ввести с клавиатуры число. Определить, сколько в введенном числе четных цифр, а сколько нечетных.
Если число делится без остатка на 2 (т. е. остаток равен нулю), значит оно четное.
Увеличиваем на 1 счетчик четных цифр (статическая переменная even).
Иначе число нечетное, увеличиваем счетчик нечетных цифр (статическая переменная odd).
Вывести на экран сообщение: "Even: а Odd: b", где а - количество четных цифр, b - количество нечетных цифр.

Пример для числа 4445:
Even: 3 Odd: 1
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char [] nums = reader.readLine().toCharArray();

        for (char ch : nums) {
            int n = Character.getNumericValue(ch);
            if (n % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        System.out.printf("Even: %d Odd: %d", even, odd);
    }
}
