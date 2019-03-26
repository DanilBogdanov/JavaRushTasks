package com.javarush.task.task03.task0307;

/* 
Создать 10 зергов, 5 протоссов и 12 терран.
Дать им всем уникальные имена.
*/

public class Solution {
    public static void main(String[] args) {
        for (int i = 0; i < 12; i++) {
            if (i < 10) {
                new Zerg().name = "zerg" + i;
            }
            if (i < 5) {
                new Protoss().name = "Protos" + i;
            }
            if (i < 12) {
                new Terran().name = "Terran" + i;
            }
        }
    }

    public static class Zerg {
        public String name;
    }

    public static class Protoss {
        public String name;
    }

    public static class Terran {
        public String name;
    }
}
