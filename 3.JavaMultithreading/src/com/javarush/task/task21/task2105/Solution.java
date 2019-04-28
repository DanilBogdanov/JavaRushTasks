package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public int hashCode() {
        int f = first != null ? first.hashCode(): 123;
        int l = last != null ? last.hashCode(): 321;
        return 31 * (f + l);

    }

    @Override
    public boolean equals(Object n) {
        /*if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof Solution))
            return false;
        if (this.hashCode() != o.hashCode()) return false;
        Solution n = (Solution) o;
        if ((first == null) || (last == null) || (n.first == null) || (n.last == null)) return false;
        return n.first.equals(first) && n.last.equals(last);*/

        if (n == null) return false;
        if (n == this) return true;
        if (n.hashCode() != hashCode()) return false;
        //if (!(n instanceof Solution)) return false;
        if ((n instanceof Solution)) return true;


        Solution sol = (Solution) n;
        if ((first == null) || (last == null) || (sol.first == null) || (sol.last == null)) return false;

        return (sol.first.equals(first) && (sol.last.equals(last)));
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
