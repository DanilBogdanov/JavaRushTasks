package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

public class MyFileVisitor extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        List<String> list = Files.readAllLines(file);

        for (String s : list) {
            if (s.contains("world")) {
                System.out.println(file + " || this file have \"world\"");
                break;
            }

            if (s.contains("рот")) {
                System.out.println(file + " || this file have rot || " + s);
                break;
            }
        }



        return super.visitFile(file, attrs);
    }
}
