package com.javarush.task.task18.task1808;

/* 
Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать большую часть.
Закрыть потоки.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String fileName1 = "";
        String fileName2 = "";
        String fileName3 = "";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
            fileName3 = reader.readLine();

            FileInputStream  fis1 = new FileInputStream(fileName1);
            FileOutputStream fos2 = new FileOutputStream(fileName2);
            FileOutputStream fos3 = new FileOutputStream(fileName3);

            byte [] buffer = new byte[fis1.available()];
            int count = fis1.read(buffer);//10  01234 56789
            int index = count - (count / 2) ;
            fos2.write(buffer, 0, index);

            fos3.write(buffer, index , count - index);

            fis1.close();
            fos2.close();
            fos3.close();

        } catch (IOException e) {

        }
    }

    public static void print(byte[] array) {
        for (byte i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


}
