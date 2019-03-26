package com.javarush.task.task19.task1906;

/* 
Четные символы
Считать с консоли 2 имени файла.
Вывести во второй файл все символы с четным порядковым номером (нумерация начинается с 1).

Пример первого файла:
text in file
Вывод во втором файле:
eti ie
Закрыть потоки ввода-вывод


Требования:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна записывать во второй файл все байты из первого файла с четным порядковым номером (используй FileWriter).
6. Поток записи в файл (FileWriter) должен быть закрыт.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String fileName1 = reader.readLine();
            String fileName2 = reader.readLine();
            try (FileReader fileReader = new FileReader(fileName1);
                 FileWriter fileWriter = new FileWriter(fileName2) ) {
                int buffer = fileReader.read();
                while (fileReader.ready()) {
                    fileWriter.write(fileReader.read());
                    fileReader.read();
                }
            } catch (IOException e) {

            }
        }catch(IOException e) {

        }
    }
}
