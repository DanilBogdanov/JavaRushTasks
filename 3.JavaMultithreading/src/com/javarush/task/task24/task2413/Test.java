package com.javarush.task.task24.task2413;

public class Test implements Cloneable {

    public static void main(String[] args) {
        Test test = new Test();
        Inner inner = (new Test()).new Inner();

        Test t = test.clone();
    }

    @Override
    public Test clone() {
        try {
            return (Test) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public class Inner {
        int i;

    }
}
