package com.javarush.task.task30.task3008;

public class Test {
    public static void main(String[] args) {
        Message message = new Message(MessageType.TEXT, null);

        System.out.println("".equals(message.getData()));
    }
}
