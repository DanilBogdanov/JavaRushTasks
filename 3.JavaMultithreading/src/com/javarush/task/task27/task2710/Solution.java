package com.javarush.task.task27.task2710;

/* 
Расставьте wait-notify
*/
public class Solution {
    public static void main(String[] args) {
        Mail mail = new Mail();

        Thread amigo = new Thread(new Person(mail));
        Thread server = new Thread(new MailServer(mail));

        server.start();
        amigo.start();
    }
}
