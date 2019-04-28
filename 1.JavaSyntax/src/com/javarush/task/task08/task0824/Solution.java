package com.javarush.task.task08.task0824;

/* 
Собираем семейство
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Выведи все объекты Human на экран (Подсказка: используй метод toString() класса Human).
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Human> humans = new ArrayList<>();
        humans.add(new Human("Pezduk", true, 1));//0
        humans.add(new Human("Pezduk2", true, 2));//1
        humans.add(new Human("Pizduska", false, 3));//2
        humans.add(new Human("Mother", false, 23));//3
        humans.add(new Human("Father", true, 30));//4
        humans.get(3).children.add(humans.get(0));
        humans.get(3).children.add(humans.get(1));
        humans.get(3).children.add(humans.get(2));
        humans.get(4).children.add(humans.get(0));
        humans.get(4).children.add(humans.get(1));
        humans.get(4).children.add(humans.get(2));
        humans.add(new Human("Ded1", true, 59));//5
        humans.get(5).children.add(humans.get(3));
        humans.add(new Human("DedF", true, 60));//6
        humans.get(6).children.add(humans.get(4));
        humans.add(new Human("BabkaM", false, 50));//7
        humans.get(7).children.add(humans.get(3));
        humans.add(new Human("BabkaF", false, 60));
        humans.get(8).children.add(humans.get(4));

        for (Human human : humans) {
            System.out.println(human);
        }
    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
