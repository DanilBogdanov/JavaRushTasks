package com.javarush.task.task18.task1809;

/* 
Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке.
Закрыть потоки.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName1 = reader.readLine();
            String fileName2 = reader.readLine();
            FileInputStream fis = new FileInputStream(fileName1);
            FileOutputStream fos = new FileOutputStream(fileName2);

            byte[] buffer = new byte[fis.available()];
            int count = fis.read(buffer);
            byte[] reverseArray = new byte[count];

            for (int i = 0; i < count; i++) {
                reverseArray[count - i - 1] = buffer[i];
            }

            fos.write(reverseArray);

            fis.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
