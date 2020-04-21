package com.javarush.task.task31.task3112;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channel;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.*;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("/home/danil/test"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        URL url = new URL(urlString);
        String fileName = urlString.substring(urlString.lastIndexOf("/") + 1);
        Path tempFile = Files.createTempFile("temp-", "javarush");

        Files.copy(url.openStream(), tempFile, StandardCopyOption.REPLACE_EXISTING);
        Path targetPath = Paths.get(downloadDirectory + "/" + fileName);
        Path result = Files.move(tempFile, targetPath, StandardCopyOption.REPLACE_EXISTING);



        return result;
    }
}
