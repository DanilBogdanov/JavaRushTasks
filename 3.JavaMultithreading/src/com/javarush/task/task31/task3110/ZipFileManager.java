package com.javarush.task.task31.task3110;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileManager {
    private Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception {
        try (ZipOutputStream zos = new ZipOutputStream(Files.newOutputStream(zipFile))) {
            ZipEntry zipEntry = new ZipEntry(source.getFileName().toString());
            zos.putNextEntry(zipEntry);

            try (InputStream is = Files.newInputStream(source)) {
                byte[] buffer = new byte[1024 * 1024];
                int len = 0;
                while (is.available() > 0) {
                    len = is.read(buffer);
                    zos.write(buffer, 0, len);
                }
            }
            zos.closeEntry();
        }
    }
}
