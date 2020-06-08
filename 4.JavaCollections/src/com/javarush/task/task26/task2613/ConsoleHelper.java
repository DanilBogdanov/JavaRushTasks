package com.javarush.task.task26.task2613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    /*1. Создай в ConsoleHelper два статических метода:
1.1 writeMessage(String message), который будет писать в консоль наше сообщение.
1.2 String readString(), который будет считывать с консоли строку и возвращать ее.
Если возникнет какое-то исключение при работе с консолью, то перехватим его и не будем обрабатывать.
Кстати, создадим только один экземпляр BufferedReader-а, в статическом поле bis.

2. Создай пакет exception, в который поместим два checked исключения:
2.1 InterruptOperationException будем кидать, когда нужно прервать текущую операцию и выйти из приложения.
2.2 NotEnoughMoneyException будем кидать, когда не сможем выдать запрашиваемую сумму.

*/
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        String result = "";
        try {
            result = bis.readLine();
        } catch (IOException e) {

        }
        return result;
    }

    public static String askCurrencyCode() {
        writeMessage("Enter currency code:");
        String result = "";
        while ((result = readString()).length() != 3) {
            writeMessage("Code invalid, repeat");
        }
        return result.toUpperCase();
    }
}
