package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String firstFileName = reader.readLine();
            String secondFileName = reader.readLine();
            String thirdFileName = reader.readLine();

            FileOutputStream  fosFirstFile = new FileOutputStream(firstFileName);
            FileInputStream fisSecondFile = new FileInputStream(secondFileName);
            FileInputStream fisThirdFile = new FileInputStream(thirdFileName);

            byte[] buffer = new byte[1000];

            while (fisSecondFile.available() > 0) {
                int length = fisSecondFile.read(buffer);
                fosFirstFile.write(buffer, 0, length);
            }

            while (fisThirdFile.available() > 0) {
                int length = fisThirdFile.read(buffer);
                fosFirstFile.write(buffer, 0, length);
            }

            fosFirstFile.close();
            fisSecondFile.close();
            fisThirdFile.close();
        } catch (IOException e) {

        }
    }
}
