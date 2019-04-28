package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws Exception{
        System.out.println(new Solution(4));

        Solution solution = new Solution(5);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:/1.txt"));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:/1.txt"));
        oos.writeObject(solution);

        System.out.println(solution);
        Solution loadSol = (Solution) ois.readObject();
        System.out.println("load - " + loadSol);
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;


    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
