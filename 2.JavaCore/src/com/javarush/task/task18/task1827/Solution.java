package com.javarush.task.task18.task1827;

import java.io.*;
/* 
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //args = new String[]{"-c", "Шорты пляжные синие", "159.00", "12"};
        if (args.length >= 4 && "-c".equals(args[0])) {
            char[] resultId;
            char[] productName = args[1].toCharArray();
            char[] price = args[2].toCharArray();
            char[] qantity = args[3].toCharArray();
            char[] outputString = new char[8 + 30 + 8 + 4];
            int maxId = 0;

            for (int i = 0; i < outputString.length; i++) {
                outputString[i] = ' ';
            }

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                String fileName = reader.readLine();

                try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
                     FileWriter fileWriter = new FileWriter(fileName, true)) {
                    while (fileReader.ready()) {
                        String buffer = fileReader.readLine();
                        int id = Integer.parseInt(buffer.substring(0, 8).replace(" ", ""));
                        maxId = (maxId < id) ? id : maxId;
                    }

                    maxId++;
                    resultId = Integer.toString(maxId).toCharArray();

                    addToarray(outputString, resultId,0);
                    addToarray(outputString, productName, 8);
                    addToarray(outputString, price, 8 + 30);
                    addToarray(outputString, qantity, 8 + 30 + 8);

                    fileWriter.write("\n");
                    fileWriter.write( outputString);
                    // System.out.println("finish");
                } catch (Exception e) {

                }

            } catch (IOException e) {

            }
        }
    }

    public static void addToarray(char[] array, char[] string, int start) {
        int z = 1, iы = 34, ii = 8;

        for (int i = 0; i < string.length; i++) {
            array[start + i] = string[i];
        }
    }

}
