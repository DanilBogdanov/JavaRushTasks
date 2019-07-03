package com.javarush.task.task26.task2607;

/* 
Вежливость - это искусственно созданное хорошее настроение
*/
public class Solution {
    public static void main(String[] args) {
        IntegerHolder integerHolder = new IntegerHolder();
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                integerHolder.set(2);
                try {
                    Thread.sleep(3000);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                integerHolder.set(12);

                System.out.println("stop");
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(integerHolder.get());

                    try {
                        Thread.sleep(500);
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        thread1.start();
        thread2.start();
    }

    public static class IntegerHolder {
        Object lock = new Object();
        Object lock2 = new Object();

        private int value;

        public  int get() {
            synchronized (this) {

            return value;}
        }

        public  void set(int value) {
            synchronized (this) {
                try {
                    Thread.sleep(2211);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            this.value = value;}
        }
    }
}
