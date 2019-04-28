package com.javarush.task.task20.task2013;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Externalizable Person
*/
public class Solution {
    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public Person() {

        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeObject(father);
            out.writeObject(mother);
            out.writeInt(age);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            firstName = (String) in.readObject();
            lastName = (String) in.readObject();
            father = (Person) in.readObject();
            mother = (Person) in.readObject();
            age = in.readInt();
            children = (List<Person>) in.readObject();
        }

        @Override
        public String toString() {
            String result = "";

            result += "Pers: --" + firstName + "-" + lastName + "-" + age + "--\n" +
                    "mother: --" + mother.firstName + "--\n" +
                    "father: --" + father.firstName + "--\n" +
                    "kids: --" + (children.size() > 0 ? children.get(0).firstName : "") + "-" + (children.size() > 1 ? children.get(1).firstName : "") + "--\n";

            return result;
        }

    }


    public static void main(String[] args) throws Exception {
        Person pers1 = new Person("Person1", "PersonLastName", 12);
        Person mother = new Person("Mother", "LastNameMother", 50);
        Person father = new Person("Father", "LastNameFather", 55);
        Person child1 = new Person("Kid1", "Kid1LastName", 1);
        Person child2 = new Person("Kid2", "Kid2LastName", 2);
        pers1.setMother(mother);
        pers1.setFather(father);
        List<Person> childs = new ArrayList<>();
        childs.add(child1);
        childs.add(child2);
        pers1.setChildren(childs);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:/1.txt"));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:/1.txt"));
        oos.writeObject(pers1);
        Person loadPers = (Person) ois.readObject();
        System.out.println(pers1);
        System.out.println(loadPers);
    }
}
