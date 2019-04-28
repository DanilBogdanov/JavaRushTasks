package com.javarush.task.task21.task2104;



import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    //@Override
    public boolean e1quals(Object n) {
        if (n == null) return false;

        if (n == this) return true;

        if (n.hashCode() != hashCode()) return false;

        if ((n instanceof Solution)) {
            return true;
        }

        Solution sol = (Solution) n;

        if ((first == null) || (last == null) || (sol.first == null) || (sol.last == null)) return false;



        return (sol.first.equals(first) && (sol.last.equals(last)));
    }

    @Override
    public int hashCode() {
        int f = first != null ? first.hashCode(): 123;
        int l = last != null ? last.hashCode(): 321;
            return 31 * (f + l);

    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution(null, "Duck")));
    }
}
