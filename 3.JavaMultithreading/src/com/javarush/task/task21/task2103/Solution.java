package com.javarush.task.task21.task2103;

/* 
Все гениальное - просто!
//return (a && b && c && !d) || (!a && c) || (!b && c) || (c && d);

*/
public class Solution {
    public static boolean calculate(boolean a, boolean b, boolean c, boolean d) {
        return c ;
    }

    public static void main(String[] args) {
        boolean t = true;
        boolean f = false;
        System.out.println(calculate(t, t, t, t));//true
        System.out.println(calculate(f,f,f,f));//false
        System.out.println(calculate(t, f, f, t));//false
        System.out.println(calculate(f, t, t, f));//true
        System.out.println(calculate(f, f, t, f));
        System.out.println(calculate(f, t, t, f));
        System.out.println(calculate(f, t, t, f));
        System.out.println(calculate(f, t, t, f));
        System.out.println(calculate(f, t, t, f));

    }
}
