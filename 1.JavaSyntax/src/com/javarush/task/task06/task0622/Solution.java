package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/* 
Числа по возрастанию
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
*/

public class Solution {
    int i;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            nums.add(Integer.parseInt(reader.readLine()));
        }

        Collections.sort(nums);

        for (int  i : nums) {
            System.out.println(i);
        }

        int y ;

        System.out.println(new Solution().i);


    }
}
