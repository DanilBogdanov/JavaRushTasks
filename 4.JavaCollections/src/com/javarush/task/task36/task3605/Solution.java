package com.javarush.task.task36.task3605;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* 
Использование TreeSet
Первым параметром приходит имя файла: файл1.
файл1 содержит только буквы латинского алфавита, пробелы, знаки препинания, тире, символы перевода каретки.
Отсортируй буквы по алфавиту и выведи на экран первые 5 различных букв в одну строку без разделителей.
Если файл1 содержит менее 5 различных букв, то выведи их все.
Буквы различного регистра считаются одинаковыми.
Регистр выводимых букв не влияет на результат.
Закрой потоки.


*/
//todo to solve task
public class Solution {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get(args[0]);
        String string = "";
        //string = Files.readString(path);
        List<String> list = Files.readAllLines(path);
        for (String s : list) {
            string += s;
        }

        string = string.toLowerCase();
        string = string.replaceAll("[^a-zа-я]", "");
        char[] arch = string.toCharArray();
        TreeSet<Character> chSet = new TreeSet<>();

        for (char ch : arch) {
            chSet.add(ch);
        }

        Iterator<Character> iterator = chSet.iterator();
        for (int i = 0; i < 5 && i < chSet.size(); i++) {
            System.out.print(iterator.next());
        }
    }
}
