package com.javarush.task.task32.task3204;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
    public static class MyHandler implements InvocationHandler {
        Person person;
        public MyHandler(Person person) {
            this.person = person;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println(proxy.getClass().getName());
            System.out.println(method.getName());
            if (args != null) {
                System.out.println("length of args = " + args.length);
                int i = 0;
                for (Object o : args) {
                    System.out.println("item - " + i + " = " + o);
                    i++;
                }
            }
            //return method.invoke("asdf");
            method.invoke(person, args);
            System.out.println("===============");
            return null;
        }
    }

    public static void main(String[] args) {
        Man man = new Man("Danil", 34, "Ufa", "Russia");
        Person person = (Person) Proxy.newProxyInstance(man.getClass().getClassLoader(), man.getClass().getInterfaces(), new MyHandler(man));

        person.introduce("Dan");
        person.sayAge(12);
        person.sayFrom("1", "1");
    }

    public static interface Person {

        public void introduce(String name);

        public void sayAge(int age);

        public void sayFrom(String city, String country);
    }

    public static class Man implements Person {

        private String name;
        private int age;
        private String city;
        private String country;

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getCity() {
            return city;
        }

        public String getCountry() {
            return country;
        }

        public Man(String name, int age, String city, String country) {
            this.name = name;
            this.age = age;
            this.city = city;
            this.country = country;
        }

        @Override
        public void introduce(String name) {

            System.out.println("Меня зовут " + name);
        }

        @Override
        public void sayAge(int age) {
            System.out.println("Мне " + age + " лет");
        }

        @Override
        public void sayFrom(String city, String country) {

            System.out.println("Я из города " + city + ", " + country);
        }

        //..геттеры, сеттеры, и т.д.
    }

}
