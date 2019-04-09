package com.javarush.task.task21.task2106;

import java.util.Date;

/* 
Ошибка в equals/hashCode
*/
public class Solution {
    private int anInt;
    private String string;
    private double aDouble;
    private Date date;
    private Solution solution;

    public Solution(int anInt, String string, double aDouble, Date date, Solution solution) {
        this.anInt = anInt;
        this.string = string;
        this.aDouble = aDouble;
        this.date = date;
        this.solution = solution;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public boolean equ1als(Object o) {
        if (o == null) return false;
        if (this == o) return true;

        if (this.hashCode() != o.hashCode()) return false;
        //if (!(o instanceof Solution)) return false;
        if (o instanceof Solution) return true;

        Solution solution1 = (Solution) o;

        /*
        if (Double.compare(solution1.aDouble, aDouble) != 0) return false;
        if (anInt != solution1.anInt) return false;
        if (date != null ? !date.equals(solution1.date) : solution1.date == null) return false;
        if (solution != null ? !solution.equals(solution1.solution) : solution1.solution == null) return false;
        if (string != null ? !string.equals(solution1.string) : solution1.string == null) return false;*/

        if (Double.compare(solution1.aDouble, aDouble) != 0) return false;
        if (anInt != solution1.anInt) return false;
        if ((date == null) || (solution1.date == null) || !(date.equals(solution1.date))) return false;
        if ((solution == null) || (solution1.solution == null) || !(solution1.solution.equals(solution))) return false;
        if ((string == null) || (solution1.string == null) || !(solution1.string.equals(string))) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public Solution() {

    }

    static class a {}
    static class b extends a {}
    static class c extends b {}

    public static void main(String[] args) {
        System.out.println(65662266 * 23222223);
    }
}
