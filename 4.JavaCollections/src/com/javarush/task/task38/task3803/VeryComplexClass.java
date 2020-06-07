package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        String s = (String) new Object();
    }

    public void methodThrowsNullPointerException() {
        String n = null;
        n.equals("adf");
    }

    public static void main(String[] args) {

    }
}
