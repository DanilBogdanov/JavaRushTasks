package com.javarush.task.task03.task0312;

/* 
Конвертируем время
public static int convertToSeconds(int hour)
*/

public class Solution {
    public static int convertToSeconds(int hour) {
        return hour * 3600;
    }

    public static void main(String[] args) {
        //напишите тут ваш код
        for (int i = 0; i < 2; i++) {
            System.out.println(convertToSeconds(i + 1));
        }
    }
}
