package com.javarush.task.task18.task1820;

/* 
Округление чисел
Считать с консоли 2 имени файла.
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415.
Округлить числа до целых и записать через пробел во второй файл.
Закрыть потоки.

Принцип округления:
3.49 => 3
3.50 => 4
3.51 => 4
-3.49 => -3
-3.50 => -3
-3.51 => -4


Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Для первого файла создай поток для чтения. Для второго - поток для записи.
3. Считать числа из первого файла, округлить их и записать через пробел во второй.
4. Должны соблюдаться принципы округления, указанные в задании.
5. Созданные для файлов потоки должны быть закрыты.

*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String firstFileName = reader.readLine();
            String secondFileName = reader.readLine();

            BufferedReader firstFileReader = new BufferedReader(new FileReader(firstFileName));
            BufferedWriter secondFileWriter = new BufferedWriter(new FileWriter(secondFileName));

            String result = "";
            while (firstFileReader.ready()) {
                String str = firstFileReader.readLine();
                String [] nums = str.split(" ");
                for (String s : nums) {
                    try {
                        double num = Double.parseDouble(s);
                        result += Math.round(num) + " ";
                    } catch (NullPointerException e) {

                        result += s + " ";
                    }
                }
            }

            secondFileWriter.write(result);

            firstFileReader.close();
            secondFileWriter.close();
        } catch (IOException e) {

        }
    }
}
