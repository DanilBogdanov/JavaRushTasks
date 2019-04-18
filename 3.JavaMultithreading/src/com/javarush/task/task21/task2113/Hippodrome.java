package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    static Hippodrome game;
    private List<Horse> horses;
    

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) {
        game = new Hippodrome(new ArrayList<>());
        game.horses.add(new Horse("Horse1", 3, 0));
        game.horses.add(new Horse("Horse2", 3, 0));
        game.horses.add(new Horse("Horse3", 3, 0));

        game.run();
        game.printWinner();
    }

    public void run() {
        for (int i = 1; i <= 100; i++) {
            try {

              move();
              print();

              Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }

    public void move() {
        for (Horse horse : getHorses()) {
            horse.move();

        }
    }

    public void print() {

        for (Horse horse : getHorses()) {
            horse.print();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        Horse winner = null;
        if (getHorses().size() != 0) {
            winner = getHorses().get(0);
            for (Horse horse : getHorses()) {
                if (horse.getDistance() > winner.getDistance()) {
                    winner = horse;
                }
            }
        }
        return winner;
    }

    public void printWinner() {
        Horse winner = getWinner();
        System.out.printf("Winner is %s!", winner.getName());
    }
}
