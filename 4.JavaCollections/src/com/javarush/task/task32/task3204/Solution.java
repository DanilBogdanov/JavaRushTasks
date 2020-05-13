package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());


    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        List<Integer> nums = getRange(48, 57);
        List<Integer> upLetters = getRange(65, 90);
        List<Integer> downLetters = getRange(97, 122);
        List<Integer> allChar = new ArrayList<>();
        allChar.addAll(nums);
        allChar.addAll(downLetters);
        allChar.addAll(upLetters);

        boolean hasNum;
        boolean hasUpLet;
        boolean hasDownLet;
        int lengthPas = 8;

        do {
            hasNum = false;
            hasUpLet = false;
            hasDownLet = false;
            result.reset();

            for (int i = 0; i < lengthPas; i++) {
                int randomPos = (int) (Math.random() * allChar.size());
                int let = allChar.get(randomPos);
                result.write(let);

                if (nums.contains(let)) {
                    hasNum = true;
                }
                if (upLetters.contains(let)) {
                    hasUpLet = true;
                }
                if (downLetters.contains(let)) {
                    hasDownLet = true;
                }
            }
        } while (!(hasNum && hasUpLet && hasDownLet));
        return result;
    }

    private static List<Integer> getRange(int a, int b) {
        List<Integer> result = new ArrayList<>();
        for (int i = a; i <= b; i++) {
            result.add(i);
        }
        return result;
    }
}