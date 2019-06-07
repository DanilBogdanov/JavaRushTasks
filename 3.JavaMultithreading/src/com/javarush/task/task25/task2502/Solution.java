package com.javarush.task.task25.task2502;

import java.util.*;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            //todo wheels = new ArrayList<>();
            ArrayList<Wheel> wheelsMock = new ArrayList<>();
            for (String wheel : loadWheelNamesFromDB()) {
                wheelsMock.add(Wheel.valueOf(wheel));
            }
            if (wheelsMock.size() == Wheel.values().length &&
                wheelsMock.containsAll(Arrays.asList(Wheel.values()))) {
                wheels = wheelsMock;
            } else {
                throw new RuntimeException("fuck");
            }

        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
        new Car();
    }
}
