package com.javarush.task.task24.task2412;

import java.util.Comparator;

public class Test {
    String name;

    public static void main(String[] args) {
        Test test1 = new Test();
        Test test2 = new Test();

        Comparator<Test> comp = Comparator.comparing(test -> test.name);
    }
}
