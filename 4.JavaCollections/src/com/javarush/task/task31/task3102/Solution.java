package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> result = new ArrayList<>();
        Queue<File> queue = new LinkedList<>();
        queue.add(new File(root));

        while (!queue.isEmpty()) {
            File file = queue.remove();

            if (file != null) {
                if (file.isFile()) {
                    result.add(file.getCanonicalPath());
                } else if (file.isDirectory()) {
                    queue.addAll(Arrays.asList(file.listFiles()));
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        try {
            List<String> list = getFileTree("/home/danil/test");
            for (String s: list) {
                System.out.println(s);
            }
        } catch (IOException e) {
            System.out.println("bitch");
        }
    }
}
