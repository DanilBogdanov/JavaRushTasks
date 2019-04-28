package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
Создать класс Cat (кот) с пятью инициализаторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет (имя, адрес и возраст неизвестны, это бездомный кот)
- вес, цвет, адрес (чужой домашний кот)

Задача инициализатора - сделать объект валидным.
Например, если вес неизвестен, то нужно указать какой-нибудь средний вес.
Кот не может ничего не весить.
То же касательно возраста.
А вот имени может и не быть (null).
То же касается адреса: null.
*/


public class Cat {
    //напишите тут ваш код
    String name;
    int weight;
    int age;
    String color;
    String address;

    public void initialize(String name) {
        this.name = name;
        weight = 3;
        age = 2;
        color = "some color";
    }

    public void initialize(String name, int weigth, int age) {
        this.name = name;
        this.weight = weigth;
        this.age = age;
        color = "some color";
    }

    public void initialize(String name, int age) {
        this.name = name;
        this.age = age;
        weight = 2;
        color = "some color";
    }

    public void initialize(int weigth, String color) {
        this.weight = weigth;
        this.color = color;
        age = 8;
    }

    public void initialize(int weigth, String color, String address) {
        this.weight = weigth;
        this.color = color;
        this.address = address;
        age = 8;
    }

    public static void main(String[] args) {

    }
}
