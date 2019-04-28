package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        //out.writeObject(fileName);
        //out.close();

    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }



    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        //in.readObject()
        stream = new FileOutputStream(fileName, true);
        //in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) {
        try {
            Solution solution = new Solution("D:/2.txt");
            solution.writeObject("fuck");
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:/1.txt"));
            oos.writeObject(solution);
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:/1.txt"));
            Solution loadSolution = (Solution) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
