package com.javarush.task.task20.task2009;

import java.io.*;

/*
Как сериализовать static?
*/
public class Solution {
    public static class ClassWithStatic implements Serializable {
        public static String staticString = "This is a static test string";
        public static int st = 5;
        public int i;
        public int j;

        private void searial (ObjectOutputStream o) throws IOException {
            o.writeChars(staticString);
        }


    }

    public static void main(String[] args) throws Exception{


        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:/1.txt"));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:/1.txt"));

        ClassWithStatic cl = new ClassWithStatic();
        System.out.println(ClassWithStatic.staticString);

        oos.writeUTF(ClassWithStatic.staticString);
        oos.writeObject(cl);

        ClassWithStatic.staticString = "asdf";
        System.out.println(ClassWithStatic.staticString);

        ClassWithStatic.staticString = ois.readUTF();
        cl = (ClassWithStatic) ois.readObject();

        System.out.println(ClassWithStatic.staticString);
    }


}
