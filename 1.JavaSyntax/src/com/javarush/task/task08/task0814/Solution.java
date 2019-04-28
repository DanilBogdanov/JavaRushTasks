package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
Больше 10? Вы нам не подходите
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Класс Solution должен содержать только три метода.
4. Метод createSet() должен создавать и возвращать множество HashSet состоящих из 20 различных чисел.
5. Метод removeAllNumbersMoreThan10() должен удалять из множества все числа больше 10.
*/

public class Solution {
    public static HashSet<Integer> createSet() {
        HashSet<Integer> set = new HashSet<Integer>();
        int buffer;
        for (int i = 0; i < 20; i++) {
            buffer = (int) (Math.random() * 100);
            if (set.contains(buffer)) {
                i--;
                continue;
            }
            set.add(buffer);
        }

        return set;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set) {
        set.removeIf((Integer n) -> (n > 10));
        return set;
    }

    public static void main(String[] args) {
//        HashSet<Integer> set = createSet();
//        removeAllNumbersMoreThan10(set);
//        set.forEach((Integer i) -> System.out.println(i));
    }
}
