package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private String name;
        private String lastName;
        private int age;
        private String address;
        private boolean sex;
        private Human wife;

        public Human(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Human(String name, String address, boolean sex, Human wife) {
            this.name = name;
            this.address = address;
            this.sex = sex;
            this.wife = wife;
        }

        public Human(String name, int age, String address, boolean sex) {

            this.name = name;
            this.age = age;
            this.address = address;
            this.sex = sex;
        }

        public Human(String name, int age, String address) {

            this.name = name;
            this.age = age;
            this.address = address;
        }

        public Human(String name, String lastName, int age, String address, boolean sex) {

            this.name = name;
            this.lastName = lastName;
            this.age = age;
            this.address = address;
            this.sex = sex;
        }

        public Human(String name, String lastName, int age, String address) {

            this.name = name;
            this.lastName = lastName;
            this.age = age;
            this.address = address;
        }

        public Human(String name, String lastName, int age) {

            this.name = name;
            this.lastName = lastName;
            this.age = age;
        }

        public Human(String name, String lastName) {

            this.name = name;
            this.lastName = lastName;
        }

        public Human(String name) {

            this.name = name;
        }

        public Human(String name, String lastName, int age, String address, boolean sex, Human wife) {

            this.name = name;
            this.lastName = lastName;
            this.age = age;
            this.address = address;
            this.sex = sex;
            this.wife = wife;
        }
    }
}
