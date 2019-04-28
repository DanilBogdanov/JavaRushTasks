package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
1. Создай список чисел.
2. Добавь в список 10 чисел с клавиатуры.
3. Вывести на экран длину самой длинной последовательности повторяющихся чисел в списке.

Пример для списка 2, 4, 4, 4, 8, 8, 4, 12, 12, 14:
3

Искомое значение равно 3, т.к. самая длинная последовательность повторяющихся чисел состоит из трех четверок.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> nums = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maxLength = 1;
        int currentLength = 1;
        int buffer;

        for (int i = 0; i < 10; i++) {
            buffer = Integer.parseInt(reader.readLine());
            nums.add(buffer);
            if (i != 0 && buffer == nums.get(i - 1)) {
                currentLength++;
            } else {
                maxLength = (maxLength > currentLength) ? maxLength : currentLength;
                currentLength = 1;
            }
        }
        maxLength = (maxLength > currentLength) ? maxLength : currentLength;

        System.out.println(maxLength);



    }
}