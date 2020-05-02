package com.javarush.task.task31.task3110;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        FileManager fm = new FileManager(Paths.get("/home/danil/test"));
        List<Path> list = fm.getFileList();

        for (Path path : list) {
            System.out.println(path);
        }
    }
}
