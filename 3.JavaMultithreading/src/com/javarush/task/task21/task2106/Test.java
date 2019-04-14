package com.javarush.task.task21.task2106;



public class Test implements Cloneable {
    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public User clone() throws CloneNotSupportedException {
            User user = (User) super.clone();

            return user;
        }
    }

    public static void main(String[] args) throws Exception {
        String a = "a";
        String b = "b";

        String [] array = new String[]{a, b};
        String [] clone = array.clone();

        array[1] = "adsf";
        a = "asdfasdfasdf";
        for(String s : clone) {
            System.out.println(s);
        }
    }


}
