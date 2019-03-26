package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* 
Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел).
Слова вывести в возрастающем порядке, числа - в убывающем.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();

        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        ArrayList<String> types = new ArrayList<>();
        ArrayList<String> words = new ArrayList<>();
        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<String> arrayResult = new ArrayList<>();

        for (String str : array) {
            if (isNumber(str)) {
                types.add("int");
                nums.add(Integer.parseInt(str));
            } else {
                types.add("str");
                words.add(str);
            }
        }

        Collections.sort(nums, Collections.reverseOrder());
        Collections.sort(words);
        isGreaterThan("", "");

        Iterator<Integer> iteratorNums = nums.iterator();
        Iterator<String> iteratorWords = words.iterator();

        for (String type : types) {
            if (type.equals("int")) {
                arrayResult.add(iteratorNums.next().toString());
            } else {
                arrayResult.add(iteratorWords.next());
            }
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = arrayResult.get(i);
        }
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') // не цифра и не начинается с '-'
                    || (i == 0 && c == '-' && chars.length == 1)) // не '-'
            {
                return false;
            }
        }
        return true;
    }
}
