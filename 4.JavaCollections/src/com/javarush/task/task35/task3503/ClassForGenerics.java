package com.javarush.task.task35.task3503;

public class ClassForGenerics {
    void method(A<? extends Integer> i, A<? extends Integer> s) {
        i.setI(4);
        s.setI(5);
        i.getI();
        s.getI();
    }

    static class A<T> {
        Integer i = 2;

        public int getI() {
            return i;
        }

        public void setI(Integer i) {
            this.i = i;
        }
    }
}
