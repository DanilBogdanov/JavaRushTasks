package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.*;

class WithdrawCommand implements Command {
    @Override
    public void execute() throws InterruptOperationException {
        String code = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
        while (true) {
            ConsoleHelper.writeMessage("Enter summ:");

            try {
                int summ = Integer.parseInt(ConsoleHelper.readString());
                if (manipulator.isAmountAvailable(summ)) {
                    TreeMap<Integer, Integer> sortedMap = new TreeMap<>(Comparator.reverseOrder());
                    sortedMap.putAll(manipulator.withdrawAmount(summ));

                    for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
                        ConsoleHelper.writeMessage(String.format("\t%d - %d",
                                entry.getKey(), entry.getValue()));
                    }
                    ConsoleHelper.writeMessage("Successful operation");
                    break;
                }

            } catch (NumberFormatException e) {
                ConsoleHelper.writeMessage("Wrong summ, try again");
            } /*catch (NotEnoughMoneyException e) {
                ConsoleHelper.writeMessage("You don't have enough of money");
            }*/
        }
    }
}
