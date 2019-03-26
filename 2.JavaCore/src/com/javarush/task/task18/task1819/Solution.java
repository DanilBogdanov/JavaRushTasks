package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String firstFileName = reader.readLine();
            String secondFileName = reader.readLine();

            FileOutputStream fosFirstFile = new FileOutputStream(firstFileName);
            FileInputStream fisFirstFile = new FileInputStream(firstFileName);
            FileInputStream fisSesondFile = new FileInputStream(secondFileName);

            //reading to buffer from both files
            byte [] bufferFirstFile = new byte[fisFirstFile.available()];
            fisFirstFile.read(bufferFirstFile);
            byte [] bufferSecondFile = new byte[fisSesondFile.available()];
            fisSesondFile.read(bufferSecondFile);

            //writing both buffers to first file
            fosFirstFile.write(bufferSecondFile);
            fosFirstFile.write(bufferFirstFile);

            //close all streams
            fosFirstFile.close();
            fisFirstFile.close();
            fisSesondFile.close();
        } catch (IOException e) {

        }
    }
}
