package com.javarush.task.task19.task1907;

/* 
Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки.


Требования:
1. Программа должна считывать имя файла с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое файла (используй FileReader c конструктором принимающим String).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна выводить в консоль количество слов "world", которые встречаются в файле.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        start();

    }

    public static void start() {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName = reader.readLine();

            try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
                Pattern pattern = Pattern.compile("^world$");
                Matcher matcher;

                while (fileReader.ready()) {
                    String[] buffer = fileReader.readLine().split("\\W");
                    for (String s : buffer) {
                        matcher = pattern.matcher(s);
                        while (matcher.find()) {
                            count++;
                        }
                    }
                }
            } catch (IOException e) {

            }
        } catch (IOException e) {

        }
        System.out.println(count);
    }
}
