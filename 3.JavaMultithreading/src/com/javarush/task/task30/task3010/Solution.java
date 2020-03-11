package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

public class Solution {
    public static void main(String[] args) {
        try {
            //String str = "00";
            String str = args[0];
            str = str.toUpperCase();
            char maxChar = 49; //1

            for (char ch : str.toCharArray()) {
                if (ch < 48 || ch > 90 || (ch > 57 && ch < 65)) {
                    System.out.println("incorrect");
                    return;
                } else {
                    if (ch > maxChar) {
                        maxChar = ch;
                    }
                }
            }

            int base;
            if (maxChar >= 65) {
                base = maxChar - 55; // A -> 10, B -> 11...
            } else {
                base = maxChar - 48; // '0' -> 0, '1' -> 1...
            }
            base++;

            System.out.println(base);
        } catch (Exception e) {

        }
    }
}