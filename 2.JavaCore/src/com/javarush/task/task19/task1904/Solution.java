package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
В классе адаптере создать приватное финальное поле Scanner fileScanner. Поле инициализировать в конструкторе с одним аргументом типа Scanner.

Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950
Петров Петр Петрович 31 12 1957

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные только одного человека.


Требования:
1. PersonScanner должен быть интерфейсом.
2. Класс PersonScannerAdapter должен реализовывать интерфейс PersonScanner.
3. Класс PersonScannerAdapter должен содержать приватное поле fileScanner типа Scanner.
4. Класс PersonScannerAdapter должен содержать конструктор с параметром Scanner.
5. Метод close() класса PersonScannerAdapter должен делегировать полномочие такому же методу fileScanner.
6. Метод read() класса PersonScannerAdapter должен читать строку с файла, парсить её, и возвращать данные только одного человека, в виде объекта класса Person.
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public void close() {
            fileScanner.close();
        }

        @Override
        public Person read() {
            String[] buffer = fileScanner.nextLine().split(" ");
            //public Person(String firstName, String middleName, String lastName, Date birthDate)
            SimpleDateFormat sdf = new SimpleDateFormat("dd,MM,yy");
            Date date = new Date();
            try {
                date = sdf.parse("" + buffer[3] + "," + buffer[4] + "," + buffer[5]);
            } catch (Exception e) {

            }
            return new Person(buffer[1], buffer[2], buffer[0], date);
        }
    }
}
