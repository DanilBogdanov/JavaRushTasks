package com.javarush.task.task31.task3106;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) {
        String resultFileName = args[0];
        List<String> fileNameList = new ArrayList<>();

        for (int i = 1; i < args.length; i++) {
            fileNameList.add(args[i]);
        }
        Collections.sort(fileNameList);

        List<InputStream> isList = new ArrayList<>();
        for (String fileName : fileNameList) {
            try {
                isList.add(new FileInputStream(fileName));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        Enumeration<InputStream> enumeration = Collections.enumeration(isList);
        SequenceInputStream sis = new SequenceInputStream(enumeration);

        try (FileOutputStream fos = new FileOutputStream(resultFileName);
                ZipInputStream zis = new ZipInputStream(sis)) {
            byte [] buffer = new byte[1024 * 1024];
            int length;

            ZipEntry zipEntry = zis.getNextEntry();
            while ((length = zis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }

            sis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
