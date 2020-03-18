package com.javarush.task.task35.task3513;

public class Test {
    public static void main(String[] args) {
        Model model = new Model();
        Tile[][] array = model.getGameTiles();
        printArray(array);

        model.right();
        printArray(model.getGameTiles());
        model.right();
        printArray(array);
    }

    private static void printArray(Tile[][] array) {
        for (Tile[] tiles : array) {
            for (Tile t : tiles) {
                System.out.print(t);
            }
            System.out.println();
        }

        System.out.println("-----------------");
    }
}
