package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        String key = args[0];
        String fileName = args[1];
        String fileOutputName = args[2];

        if ("-e".equals(key)) encryption(fileName, fileOutputName);
        if ("-d".equals(key)) decoding(fileName, fileOutputName);
    }

    public static void encryption(String fileName, String fileOutputName) {
        try (FileInputStream fis = new FileInputStream(fileName);
             FileOutputStream fos = new FileOutputStream(fileOutputName)) {
            byte[] bufferRead = new byte[fis.available()];
            byte[] bufferWrite = new byte[fis.available() * 2];
            fis.read(bufferRead);

            for (int i = 0; i < bufferRead.length; i++) {
                byte firstByte = (byte) (bufferRead[i] / 2);
                byte secondByte = (byte) (bufferRead[i] - firstByte);
                bufferWrite[i * 2] = firstByte;
                bufferWrite[i * 2 + 1] = secondByte;
            }

            fos.write(bufferWrite);
        } catch (IOException e) {

        }
    }

    public static void decoding(String fileName, String fileOutputName) {
        try (FileInputStream fis = new FileInputStream(fileName);
             FileOutputStream fos = new FileOutputStream(fileOutputName)) {
            byte[] bufferRead = new byte[fis.available()];
            byte[] bufferWrite = new byte[fis.available() / 2];
            fis.read(bufferRead);

            for (int i = 0; i < bufferRead.length; i += 2) {
                bufferWrite[i / 2] = (byte) (bufferRead[i] + bufferRead[i + 1]);
            }

            fos.write(bufferWrite);
        } catch (IOException e) {

        }
    }


}


/*Придумать механизм шифровки/дешифровки.

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName

где:
fileName - имя файла, который необходимо зашифровать/расшифровать.
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования.
-e - ключ указывает, что необходимо зашифровать данные.
-d - ключ указывает, что необходимо расшифровать данные.


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток для чтения из файла, который приходит вторым параметром ([fileName]).
3. Создай поток для записи в файл, который приходит третьим параметром ([fileOutputName]).
4. В режиме "-e" программа должна зашифровать [fileName] и записать в [fileOutputName].
5. В режиме "-d" программа должна расшифровать [fileName] и записать в [fileOutputName].
6. Созданные для файлов потоки должны быть закрыты.*/