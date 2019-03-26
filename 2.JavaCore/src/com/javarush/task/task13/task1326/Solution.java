package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.

Пример ввода:
5
8
-2
11
3
-5
2
10

Пример вывода:
-2
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> intList = new ArrayList<>();
        String fileName = reader.readLine();

        Scanner sc = new Scanner(new FileInputStream(fileName));
        while (sc.hasNext()) {
            intList.add(sc.nextInt());
        }




        Collections.sort(intList);

        intList.forEach(i -> {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        });
        reader.close();
        sc.close();
    }
}
