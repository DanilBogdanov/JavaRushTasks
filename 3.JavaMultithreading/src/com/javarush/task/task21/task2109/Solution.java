package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        public A clone() throws CloneNotSupportedException {
            A a = null;
            try {
                a = (A) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return a;
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public B clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        public C clone() throws CloneNotSupportedException {
            C clone = new C(this.getI(), this.getJ(), this.getName());

            return clone;
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {

        A a = new A(1, 1);
        B b = new B(2, 2, "nameB");
        C c = new C(3, 3, "nameC");

        C clonec = c.clone();

        System.out.println("a--" + a);
        System.out.println("b--" + b);
        System.out.println("c--" + c);
        System.out.println("cloneC--" + clonec);
    }
}
