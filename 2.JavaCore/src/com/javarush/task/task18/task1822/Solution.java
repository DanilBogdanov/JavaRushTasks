package com.javarush.task.task18.task1822;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileReader;
/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String id = args[0];
            String fileName = reader.readLine();
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

            while (fileReader.ready()) {
                String buffer = fileReader.readLine();
                String idItem = buffer.split(" ")[0];

                if (id.equals(idItem)) {
                    System.out.println(buffer);
                    break;
                }
            }

            fileReader.close();
        } catch (IOException e) {

        }
    }
}
