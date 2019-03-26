package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {


        int x = getIntFromReader();
        int y = getIntFromReader();

        int i;
        for (i = (x < y ? x : y); i >= 0; i--) {
            if ((x % i == 0) && (y % i) == 0) {
                break;
            }
        }
        System.out.println(i);

    }

    public static int getIntFromReader() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


                int i = Integer.parseInt(reader.readLine());
        if (i <= 0) throw new Exception();
                return i;





    }
}
