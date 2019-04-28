package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
Ввести с консоли имя файла.
Найти байт или байты с минимальным количеством повторов.
Вывести их на экран через пробел.
Закрыть поток ввода-вывода.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        HashMap<Integer, Integer> bytes = new HashMap<>();


        while (fis.available() > 0) {
            int buffer = fis.read();
            if (!bytes.containsKey(buffer)) {
                bytes.put(buffer, 1);
            } else {
                bytes.put(buffer, bytes.get(buffer) + 1);
            }
        }

        int minCount = -1;
        for (int i : bytes.values()) {
            if (minCount == -1) {
                minCount = i;
            }
            if (minCount > i)
                minCount = i;
        }

        for (Map.Entry<Integer, Integer> entry : bytes.entrySet()) {
            if (entry.getValue() == minCount) {
                System.out.print(entry.getKey() + " ");
            }
        }

        fis.close();
    }
}
