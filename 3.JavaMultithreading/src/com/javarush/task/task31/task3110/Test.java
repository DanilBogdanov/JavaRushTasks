package com.javarush.task.task31.task3110;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        Path zip = Paths.get("/home/danil/test/1.zip");
        Path path2 = Paths.get("/home/danil/test/2.txt");

        ZipFileManager zfm = new ZipFileManager(zip);
        zfm.addFile(path2);
    }
}
