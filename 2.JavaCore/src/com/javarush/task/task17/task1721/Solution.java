package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws CorruptedDataException {
        Solution solution = new Solution();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //ArrayList<String> bufferFirstFile = new ArrayList<>();
        //ArrayList<String> bufferSecondFile = new ArrayList<>();

        try {
            String firstFileName = reader.readLine();
            String secondFileName = reader.readLine();

            BufferedReader readerFirstFile = new BufferedReader(new InputStreamReader
                    (new FileInputStream(firstFileName)));
            BufferedReader readerSecondFile = new BufferedReader(new InputStreamReader
                    (new FileInputStream(secondFileName)));

            while (readerFirstFile.ready()) {
                allLines.add(readerFirstFile.readLine());
            }



            while (readerSecondFile.ready()) {
                forRemoveLines.add(readerSecondFile.readLine());
            }
            reader.close();
            readerFirstFile.close();
            readerSecondFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //solution.addFileToLists();
        solution.joinData();
    }

    public void joinData () throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }

    public void addFileToLists () {

    }
}
