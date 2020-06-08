package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.IllformedLocaleException;

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

    public static String readString() throws InterruptOperationException {
        String result = "";
        try {
            result = bis.readLine();
        } catch (IOException e) {

        }
        if ("EXIT".equals(result.toUpperCase())) {
            throw new InterruptOperationException();
        }
        return result;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        writeMessage("Enter currency code:");
        String result = "";
        while ((result = readString()).length() != 3) {
            writeMessage("You are invalid, repeat");
        }
        return result.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException{
        writeMessage("Enter denomination and count of " + currencyCode + ":");
        String line;
        while (!(line = readString()).matches("^\\d+ \\d+$")) {
            writeMessage("try again stupid bitch...");
        }
        return line.split(" ");
    }

    public static Operation askOperation() throws InterruptOperationException {
        Operation result;
        writeMessage("What do you want asshole?");
        for (Operation operation : Operation.values()) {
            writeMessage((operation.ordinal() + 1) + ": " + operation.toString());
        }
        while (true) {
            String line = ConsoleHelper.readString();
            int codeOperation;
            try {
                codeOperation = Integer.parseInt(line);
            } catch (NumberFormatException ne) {
                continue;
            }
            try {
                result = Operation.getAllowableOperationByOrdinal(codeOperation);
                break;
            } catch (IllegalArgumentException e) {
                writeMessage("Try again, enter valid number:");
            }
        }
        return result;
    }
}
