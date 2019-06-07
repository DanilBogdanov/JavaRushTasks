package com.javarush.task.task25.task2505;

public class Test {
    public static void main(String[] args) {
        Thread test = new Thread() {
            int i = 0;
            public void run() {
               while (!isInterrupted()) {
                   try {
                       Thread.sleep(600);
                   } catch (InterruptedException e) {
                       System.out.println("is interrupted");
                   }
                   System.out.println(i++);
                   System.out.println(getState());
                   System.out.println(isInterrupted());
                   if (isInterrupted()) {
                       System.out.println("asdfas");

                   }
               }
            }
        };

        test.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }
        test.interrupt();
        System.out.println("asdasdfasdfasdfasdfasdfasdfasdf");
    }
}
