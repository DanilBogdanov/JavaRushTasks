package com.javarush.task.task21.task2108;

/* 
Клонирование растений
*/
public class Solution {
    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        try {
            clone = tree.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);
    }

    public static class Plant{
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Tree extends Plant implements Cloneable {
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }

        @Override
        public Tree clone() {
            Tree clone = null;
            try {
                clone = (Tree) super.clone();
                clone.branches = branches.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return clone;
        }

        @Override
        public int hashCode() {
            int result = 0;
           result = 37 * result + branches.hashCode();
            result = 37 * result + super.name.hashCode();
            return result;
        }

        @Override
        public boolean equals(Object tree) {
            if (this == tree) return true;
            if (this.hashCode() != tree.hashCode()) return false;
            if (this.getClass().getName() != tree.getClass().getName()) return false;
            return true;
        }
    }
}
