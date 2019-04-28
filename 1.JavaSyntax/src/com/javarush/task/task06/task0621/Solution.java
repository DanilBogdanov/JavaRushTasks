package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Задача: У каждой кошки есть имя и кошка-мама.
Создать класс, который бы описывал данную ситуацию.
Создать два объекта: кошку-дочь и кошку-маму.
Вывести их на экран.

Новая задача: У каждой кошки есть имя, кошка-папа и кошка-мама.
Изменить класс Cat так, чтобы он мог описать данную ситуацию.
Создать 6 объектов: дедушку (папин папа), бабушку (мамина мама), папу, маму, сына, дочь.
Вывести их всех на экран в порядке: дедушка, бабушка, папа, мама, сын, дочь.

Пример ввода:
дедушка Вася
бабушка Мурка
папа Котофей
мама Василиса
сын Мурчик
дочь Пушинка

Пример вывода:
Cat name is дедушка Вася, no mother, no father
Cat name is бабушка Мурка, no mother, no father
Cat name is папа Котофей, no mother, father is дедушка Вася
Cat name is мама Василиса, mother is бабушка Мурка, no father
Cat name is сын Мурчик, mother is мама Василиса, father is папа Котофей
Cat name is дочь Пушинка, mother is мама Василиса, father is папа Котофей
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandFatherName = reader.readLine();//едушку (папин папа)
        Cat grandFather = new Cat(grandFatherName);

        String grandMotherName = reader.readLine();//бабушку (мамина мама)
        Cat grandMother = new Cat(grandMotherName);

        String fatherName = reader.readLine();//папу
        Cat father = new Cat(fatherName, null, grandFather);

        String motherName = reader.readLine();//маму
        Cat mother = new Cat(motherName, grandMother, null);

        String sonName = reader.readLine();//сына
        Cat son = new Cat(sonName, mother, father);

        String dotherName = reader.readLine();//дочь
        Cat dother = new Cat(dotherName, mother, father);

        System.out.println(grandFather);
        System.out.println(grandMother);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(son);
        System.out.println(dother);


    }

    public static class Cat {
        private String name;
        private Cat mother;
        private Cat father;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat mother, Cat father) {
            this.name = name;
            this.mother = mother;
            this.father = father;
        }

        @Override
        public String toString() {
            String mother = (this.mother == null) ? "no mother" : "mother is " + this.mother.name;
            String father = (this.father == null) ? "no father" : "father is " + this.father.name;

            return "Cat name is " + name + ", " + mother + ", " + father;
        }
    }

}
