package com.javarush.task.task31.task3105;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //args = new String[]{"/home/danil/test/2.txt", "/home/danil/test/1.zip", "/home/danil/test/res.zip"};


        Path fileName = Paths.get(args[0]);
        Path zipFile = Paths.get(args[1]);
        //Path resultFile = Paths.get(args[2]);

        Map<String, List<ByteArrayOutputStream>> mapZipEntry = new HashMap<>();
        try (ZipInputStream zin = new ZipInputStream(Files.newInputStream(zipFile))) {
            ZipEntry zipEntry;
            byte[] buffer;

            while ((zipEntry = zin.getNextEntry()) != null) {
                List<ByteArrayOutputStream> byteArraysList = new ArrayList<>();
                buffer = new byte[1024 * 1024];
                int length;
                while ((length = zin.read(buffer)) != -1) {
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    baos.write(buffer, 0, length);
                    byteArraysList.add(baos);
                }
                mapZipEntry.put(zipEntry.getName(), byteArraysList);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (ZipOutputStream zout = new ZipOutputStream(Files.newOutputStream(zipFile))) {
            for (Map.Entry<String, List<ByteArrayOutputStream>> entry : mapZipEntry.entrySet()) {

                if (!entry.getKey().endsWith(fileName.getFileName().toString())) {
                    zout.putNextEntry(new ZipEntry(entry.getKey()));
                    for (ByteArrayOutputStream baos : entry.getValue()) {
                        zout.write(baos.toByteArray());
                    }
                }

            }
            zout.putNextEntry(new ZipEntry("new/" + fileName.getFileName()));
            Files.copy(fileName, zout);
            zout.closeEntry();

        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
