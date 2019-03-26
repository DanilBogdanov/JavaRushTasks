package com.javarush.task.task18.task1828;

/* 
Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD

Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id

Значения параметров:
где id - 8 символов
productName - название товара, 30 символов
price - цена, 8 символов
quantity - количество, 4 символа
-u - обновляет данные товара с заданным id
-d - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19847   Шорты пляжные синие           159.00  12
198479  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234


Требования:
1. Программа должна считать имя файла для операций CrUD с консоли.
2. При запуске программы без параметров список товаров должен остаться неизменным.
3. При запуске программы с параметрами "-u id productName price quantity" должна обновится информация о товаре в файле.
4. При запуске программы с параметрами "-d id" строка товара с заданным id должна быть удалена из файла.
5. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
    static Map<Integer, Product> products;

    public static void main(String[] args) {
        start(args);
        //System.out.println(getProductFromArgs(args));
        //printProducts(products);

    }

    public static void start(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName = reader.readLine();

            if (args.length > 0) {
                products = readProductsFromFile(fileName);
                switch (args[0]) {
                    case "-d": {

                        int id = Integer.parseInt(args[1]);
                        products.remove(id);

                        break;
                    }
                    case "-u": {
                        if (args.length >= 5)
                            products.put(Integer.parseInt(args[1]), getProductFromArgs(args));
                        break;
                    }
                }
            }

            saveProductsToFile(fileName, products);
        } catch (IOException e) {
            System.out.println();
        }
    }

    private static Product getProductFromArgs(String[] args) {
        Product result = new Product();
        result.id = Integer.parseInt(args[1]);
        if (args.length == 5) {
            result.productName = args[2];
            result.price = Double.parseDouble(args[3]);
            result.quantity = Integer.parseInt(args[4]);
        } else {
            result.productName = "";
            for (int i = 2; i < args.length - 2; i++) {
                result.productName += args[i] + " ";
            }
            result.price = Double.parseDouble(args[args.length - 2]);
            result.quantity = Integer.parseInt(args[args.length - 1]);
        }

        return result;
    }

    private static void saveProductsToFile(String fileName, Map<Integer, Product> products) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            boolean first = true;
            for (Map.Entry entry : products.entrySet()) {
                if (first) {
                    first = false;
                } else {
                    writer.append("\r\n");
                }
                writer.write(entry.getValue().toString());

            }

        } catch (IOException e) {

        }
    }

    private static Map<Integer, Product> readProductsFromFile(String fileName) {
        Map<Integer, Product> result = new LinkedHashMap<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            while (reader.ready()) {
                Product product = new Product();
                String buffer = reader.readLine();

                //.replaceAll("\\s+$", "")
                if (buffer.charAt(0) == '\uFEFF') {
                    buffer = buffer.substring(1);
                }
                product.id = Integer.parseInt((buffer.substring(0, 8)).replaceAll("\\s+$", ""));
                product.productName = (buffer.substring(8, 38)).replaceAll("\\s+$", "");
                product.price = Double.parseDouble((buffer.substring(38, 46)).replaceAll("\\s+$", ""));
                product.quantity = Integer.parseInt((buffer.substring(46)).replaceAll("\\s+$", ""));
                result.put(product.id, product);
            }
        } catch (IOException e) {

        }
        return result;
    }

    private static void printProducts(Map<Integer, Product> products) {
        for (Map.Entry entry : products.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    private static class Product {
        int id;
        String productName;
        double price;
        int quantity;

        private Product() {

        }

        private Product(int id, String productName, double price, int quantity) {
            this.id = id;
            this.productName = productName;
            this.price = price;
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return addSpaces(id + "", 8) +
                    addSpaces(productName, 30) +
                    addSpaces(price + "", 8) +
                    addSpaces(quantity + "", 4);
        }

        private String addSpaces(String str, int length) {
            for (int i = str.length(); i < length; i++) {
                str = str + " ";
            }
            if (str.length() > length) {
                str = str.substring(0, length);
            }
            return str;
        }
    }
}


