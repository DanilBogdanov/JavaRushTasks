package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

/* 
Продвинутый поиск файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/home/danil/test");
        FileVisitor fileVisitor = new MyFileVisitor();

        Files.walkFileTree(path, fileVisitor);


        /*SearchFileVisitor searchFileVisitor = new SearchFileVisitor();

        searchFileVisitor.setPartOfName("amigo");
        searchFileVisitor.setPartOfContent("programmer");
        searchFileVisitor.setMinSize(500);
        searchFileVisitor.setMaxSize(10000);

        Files.walkFileTree(Paths.get("D:/SecretFolder"), searchFileVisitor);

        List<Path> foundFiles = searchFileVisitor.getFoundFiles();
        for (Path file : foundFiles) {
            System.out.println(file);
        }*/
    }

}
