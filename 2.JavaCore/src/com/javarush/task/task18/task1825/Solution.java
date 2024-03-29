package com.javarush.task.task18.task1825;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName = "";
            String stringBuffer = "";

            while (!"end".equals(stringBuffer = reader.readLine())) {
                int index = stringBuffer.indexOf(".part");
                fileName = stringBuffer.substring(0, index);
                if (!map.containsKey(fileName)) {
                    map.put(fileName, 1);
                } else {
                    map.put(fileName, map.get(fileName) + 1);
                }
            }

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                saveFile(entry.getKey(), entry.getValue());
            }


        } catch (IOException e) {

        }
    }

    public static void saveFile(String fileName, int countParts) {
        try (FileOutputStream fos = new FileOutputStream(fileName)) {

            for (int i = 1; i <= countParts; i++) {
                FileInputStream fis = new FileInputStream(fileName + ".part" + i);
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                fos.write(buffer);
                fis.close();
            }
        } catch (IOException e) {

        }
    }
}










/*Собираем файл из кусочков.
Считывать с консоли имена файлов.
Каждый файл имеет имя: [someName].partN.

Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.

Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end".
В папке, где находятся все прочтенные файлы, создать файл без суффикса [.partN].

Например, Lion.avi.

В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки.


Требования:
1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "end".
2. Создай поток для записи в файл без суффикса [.partN] в папке, где находятся все считанные файлы.
3. В новый файл перепиши все байты из файлов-частей *.partN.
4. Чтение и запись должны происходить с использованием буфера.
5. Созданные для файлов потоки должны быть закрыты.
6. Не используй статические переменные.*/