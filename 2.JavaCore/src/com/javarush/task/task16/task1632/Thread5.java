package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Данил on 06.08.2018.
 * @throws  IOException
 * if something will bad
 *
 * Нить 5 должна читать с консоли числа пока не введено слово "N", а потом вывести в консоль сумму введенных чисел.
 */
public class Thread5 extends Thread {

    public static void main(String[] args) {
        new Thread5().run();
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int summ = 0;
        String buffer;
        try {

            while (!"N".equals(buffer = reader.readLine())) {
                summ += Integer.parseInt(buffer);
            }
            //reader.close();

        } catch (IOException e) {

        } finally {

            System.out.println(summ);
        }
    }
}
