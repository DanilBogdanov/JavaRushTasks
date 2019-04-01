package com.javarush.task.task20.task2016;

import java.io.*;

/*
Минимум изменений
*/
public class Solution implements Serializable {
    public class A implements Serializable {
        String name = "A";

        public A(String name) {
            this.name += name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public class B extends A {
        String name = "B";

        public B(String name) {
            super(name);
            this.name += name;
        }
    }

    public class C extends B {
        String name = "C";

        public C(String name) {
            super(name);
            this.name = name;
        }
    }

    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        C c = sol.new C("fuck");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:/1.txt"));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:/1.txt"));

        oos.writeObject(c);
        C loadC =(C) ois.readObject();

        System.out.println(c);
        System.out.println(loadC);
    }
}
