package com.javarush.task.task07.task0724;

/* 
Семейная перепись
Семейная перепись
Создай класс Human с полями имя(String), пол(boolean), возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.

Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.

Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Human grandPaFarher = new Human("GrandPaFather", true, 48);
        Human grandPaMother = new Human("GrandPaMother", true, 58);
        Human grandMaFather = new Human("GrandMaFather", false, 69);
        Human grandMaMother = new Human("GrandMaMother", false, 50);
        Human father = new Human("Father", true, 40, grandPaFarher, grandMaFather);
        Human mother = new Human("Mother", false, 30, grandPaMother, grandMaMother);
        Human bart = new Human("Bart", true, 20, father, mother);
        Human liza = new Human("Liza", false, 10, father, mother);
        Human meggi = new Human("Meggi", false, 2, father, mother);

        System.out.println(grandMaFather);
        System.out.println(grandMaMother);
        System.out.println(grandPaFarher);
        System.out.println(grandPaMother);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(bart);
        System.out.println(liza);
        System.out.println(meggi);
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this(name, sex, age);
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















