package com.javarush.task.task21.task2106;



public class Test implements Cloneable {

    public static void main(String[] args) throws Exception {
        String a = "a";
        String b = a;
        StringBuffer aa = new StringBuffer("abuf");
        StringBuffer bb = aa;
        aa.append(1);
        a = "aa";

        System.out.println(a);
        System.out.println(b);
        System.out.println(aa);
        System.out.println(bb);
    }


}
