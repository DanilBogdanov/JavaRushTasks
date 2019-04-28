package com.javarush.task.task18.task1823;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileInputStream;



public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName;

            while (!"exit".equals(fileName = reader.readLine())) {
                new ReadThread(fileName).start();
            }
        } catch (IOException e) {

        }

    }

    public static class ReadThread extends Thread {
        public ReadThread(String fileName) {
            super(fileName);
        }

        @Override
        public void run() {
            try (FileInputStream fis = new FileInputStream(this.getName())) {
                int[] bytes = new int[256];
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);

                for (byte elem : buffer) {
                    bytes[elem]++;
                }

                int maxByte = 0;
                for (int i = 1; i < bytes.length; i++) {
                    if (bytes[i] > bytes[maxByte]) {
                        maxByte = i;
                    }
                }
                resultMap.put(this.getName(), maxByte);

            } catch (IOException e) {

            }

        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}





/*/*
Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit".
Передайте имя файла в нить ReadThread.
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки.


Требования:
1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "exit".
2. Для каждого файла создай нить ReadThread и запусти ее.
3. После запуска каждая нить ReadThread должна создать свой поток для чтения из файла.
4. Затем нити должны найти максимально встречающийся байт в своем файле и добавить его в словарь resultMap.
5. Поток для чтения из файла в каждой нити должен быть закрыт.
**/