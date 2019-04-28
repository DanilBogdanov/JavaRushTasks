package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.*;
import java.util.stream.Stream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();

        System.setOut(consoleStream);
        printStream(outputStream);
    }

    public static void printStream (ByteArrayOutputStream outputStream) {
        String[] strings = outputStream.toString().split(System.lineSeparator());

        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
            if (i % 2 != 0) {
                System.out.println("JavaRush - курсы Java онлайн");
            }
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
