package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Path path = Paths.get(reader.readLine());


        if (!Files.isDirectory(path)) {
            System.out.println(path.toAbsolutePath() + " - не папка");
        } else {
            MyVisitor visitor = new MyVisitor();
            Files.walkFileTree(path, visitor);
            System.out.println("Всего папок - " + visitor.countDirectories);
            System.out.println("Всего файлов - " + visitor.countFiles);
            System.out.println("Общий размер - " + visitor.totalSize);
        }
    }

    private static class MyVisitor extends SimpleFileVisitor<Path> {
        int countDirectories = -1;
        int countFiles;
        int totalSize;

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            countDirectories++;
            return super.preVisitDirectory(dir, attrs);
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

            if (Files.isRegularFile(file)) {
                countFiles++;
                totalSize += Files.readAllBytes(file).length;
            } else {
                System.out.println("pizda");
            }
            return super.visitFile(file, attrs);
        }
    }
}
