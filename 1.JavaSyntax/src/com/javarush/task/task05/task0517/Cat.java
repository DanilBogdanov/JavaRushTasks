package com.javarush.task.task05.task0517;

/* 
Создать класс Cat (кот) с пятью конструкторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст - неизвестные. Кот - бездомный)
- вес, цвет, адрес (чужой домашний кот)

Задача конструктора - сделать объект валидным.
Например, если вес не известен, то нужно указать какой-нибудь средний вес.
Кот не может ничего не весить.
То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
Конструируем котиков
*/

public class Cat {
    String name;
    int weight;
    int age;
    String color;
    String address;

    public Cat(String name) {
        this(name, 3, 2);
    }

    public Cat(String name, int weight, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.color = "some color";
    }

    public Cat(String name, int age) {
        this(name, 2, age);
    }

    public Cat(int weight, String color) {
        this(null, weight, 1);
        this.color = color;
    }

    public Cat(int weight, String color, String address) {
        this.age = 1;
        this.color = color;
        this.weight = weight;
        this.address = address;
    }

    public static void main(String[] args) {

    }
}
