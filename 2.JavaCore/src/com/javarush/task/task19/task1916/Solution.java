package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();
    public static List<String> firstList = new ArrayList<>();
    public static List<String> secondList = new ArrayList<>();

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            readFileToList(reader.readLine(), firstList);
            readFileToList(reader.readLine(), secondList);

            matchLists(firstList, secondList, lines);

            //printLines(lines);// delete before check
        } catch (IOException e) {

        }
    }

    public static void matchLists(List<String> list1, List<String> list2, List<LineItem> lines) {
        int firstItem = 0;
        int secondItem = 0;

        while ((firstItem < list1.size()) || (secondItem < list2.size())) {
            if ((firstItem == list1.size()) || (secondItem == list2.size())){ //if one of line is finish            {
                if (firstItem == list1.size()) {
                    for (int i = secondItem; i < list2.size(); i++) {
                        lines.add(new LineItem(Type.ADDED, list2.get(i)));
                    }
                    break;
                } else {
                    for (int i = firstItem; i < list1.size(); i++) {
                        lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                    }
                    break;
                }
            }

            if (list1.get(firstItem).equals(list2.get(secondItem))) {
                lines.add(new LineItem(Type.SAME, list1.get(firstItem)));
                firstItem++;
                secondItem++;
                //System.out.println(firstItem + " " + secondItem);
                continue;
            }

            if ((firstItem + 1) != list1.size() && list1.get(firstItem + 1).equals(list2.get(secondItem))) {
                lines.add(new LineItem(Type.REMOVED, list1.get(firstItem)));
                firstItem++;
                continue;
            } else if ((secondItem + 1) != list2.size() && list2.get(secondItem + 1).equals(list1.get(firstItem))) {
                lines.add(new LineItem(Type.ADDED, list2.get(secondItem)));
                secondItem++;
                continue;
            }

            firstItem++;
            secondItem++;

        }
    }

    public static void readFileToList(String fileName, List<String> list) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                list.add(reader.readLine());
            }

        } catch (IOException e) {

        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }

    public static void printLines(List<LineItem> list) {
        list.forEach((lineItem -> System.out.println(lineItem.type + " " + lineItem.line)));
    }

}
