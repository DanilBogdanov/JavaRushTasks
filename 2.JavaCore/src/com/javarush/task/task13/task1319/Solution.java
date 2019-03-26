package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.ArrayList;

/* 
Писатель в файл с консоли
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой строки.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        //writer.write(fileName);
        String buffer;

        while (true) {
            buffer = reader.readLine();
            writer.write(buffer);
            writer.newLine();
            if ("exit".equals(buffer)) {
                break;
            }
        }

        reader.close();
        writer.close();
    }
}
