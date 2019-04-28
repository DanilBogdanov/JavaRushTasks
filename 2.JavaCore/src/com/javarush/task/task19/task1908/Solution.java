package com.javarush.task.task19.task1908;

/* 
Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки.

Пример тела файла:
12 text var2 14 8ю 1

Результат:
12 14 1


Требования:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором принимающим FileReader).
4. Поток чтения из файла (BufferedReader) должен быть закрыт.
5. Программа должна записывать во второй файл все числа, через пробел, из первого файла (используй BufferedWriter с конструктором FileWriter).
6. Поток записи в файл (BufferedWriter) должен быть закрыт.
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileNameRead = reader.readLine();
            String fileNameWrite = reader.readLine();

            try (BufferedReader readerFile = new BufferedReader(new FileReader(fileNameRead));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(fileNameWrite))){
                while (readerFile.ready()) {
                    for(String s : readerFile.readLine().split(" ")) {
                        Pattern pattern = Pattern.compile("^\\d+$");
                        Matcher matcher = pattern.matcher(s);
                        if (matcher.matches()) {
                            writer.write(s + " ");
                        }
                    }
                }

            }
        } catch (IOException e) {

        }
    }
}
