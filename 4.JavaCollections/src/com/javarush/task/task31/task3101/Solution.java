package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) {
        //args = new String[]{"/home/danil/test", "/home/danil/test/out.txt"};
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File allFilesContent = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");

        FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);

        List<File> fileList = getFiles(path);


        List<File> toFOS = new ArrayList<>();
        for (File f : fileList) {
            if (f.length() <= 50) {
                toFOS.add(f);
            }
        }

        toFOS.sort((a, b) -> {
            return a.getName().compareTo(b.getName());
        });

        try (FileWriter fileWriter = new FileWriter(allFilesContent)) {
            for (File f : toFOS) {
                String res = "";
                FileReader fileReader = new FileReader(f);
                while (fileReader.ready()) {
                    fileWriter.write(fileReader.read());
                }
                fileWriter.write("\n");
                fileReader.close();
            }
        } catch (IOException e) {

        }
    }

    public static List<File> getFiles(File file) {
        List<File> result = new ArrayList<>();
        for (File f : file.listFiles()) {
            if (f.isDirectory()) {
                result.addAll(getFiles(f));
            } else if (f.isFile()) {
                result.add(f);
            }
        }
        return result;
    }
}
