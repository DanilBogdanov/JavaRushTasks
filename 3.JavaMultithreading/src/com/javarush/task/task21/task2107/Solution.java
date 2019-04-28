package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Глубокое клонирование карты
*/
public class Solution implements Cloneable {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

            System.out.println(solution.users.equals(clone.users));

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    @Override
    public int hashCode() {
        return users.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return this.hashCode() == o.hashCode();
    }


    @Override
    public Solution clone() throws CloneNotSupportedException {
        Solution solution = (Solution) super.clone();

        solution.users = new LinkedHashMap<>();

        for (Map.Entry entry : users.entrySet())
            solution.users.put((String) entry.getKey(), ((User) entry.getValue()).clone());

        return solution;
    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public User clone() throws CloneNotSupportedException {
            User user = (User) super.clone();

            return user;
        }

        @Override
        public int hashCode() {
            int result = 0;
            result = 37 * result + age;
            result = 37 * result + name.hashCode();
            return result;
        }

        @Override
        public boolean equals(Object o) {
            return this.hashCode() == o.hashCode();
        }
    }
}
