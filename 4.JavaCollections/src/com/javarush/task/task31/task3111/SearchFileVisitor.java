package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private List<Path> foundFiles = new ArrayList<>();

    public List<Path> getFoundFiles() {
        return foundFiles;
    }


    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        String stringContent = new String(content);
        String fileName = file.getFileName().toString();

        boolean hasPartOfName = partOfName == null || fileName.contains(partOfName);
        boolean hasPartOfContent = partOfContent == null || stringContent.contains(partOfContent);
        boolean isBigerThanMin = minSize == 0 || content.length >= minSize;
        boolean isLessThanMax = maxSize == 0 || content.length <= maxSize;

        if (hasPartOfContent && hasPartOfName && isBigerThanMin && isLessThanMax) {
            foundFiles.add(file);
        }
        return super.visitFile(file, attrs);
    }
}
