package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
1. Инициализируй переменную Statics.FILE_NAME полным путем к файлу с данными, который содержит несколько строк.
2. В статическом блоке считай из файла с именем Statics.FILE_NAME все строки и добавь их по отдельности в List lines.
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(Statics.FILE_NAME)));
            System.out.println("reader is ready");
            while (reader.ready()) {
                String s = reader.readLine();

                Solution.lines.add(s);
            }
        } catch (Exception e) {
            System.out.println("some trouble");
        }
    }



    public static void main(String[] args) {
        System.out.println(lines);
    }
}
