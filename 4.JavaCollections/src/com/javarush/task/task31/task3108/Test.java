package com.javarush.task.task31.task3108;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Test {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("/home/danil/test/test.zip");
        ZipOutputStream zos = new ZipOutputStream(fos);

        zos.putNextEntry(new ZipEntry("1/2/"));
        zos.close();
    }
}
