package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;

import java.util.Collection;
import java.util.Locale;

class InfoCommand implements Command {
    @Override
    public void execute() {
        Locale.setDefault(Locale.ENGLISH);
        Collection<CurrencyManipulator> manipulators = CurrencyManipulatorFactory.getAllCurrencyManipulators();
        if (manipulators.isEmpty()) {
            ConsoleHelper.writeMessage("No money available.");
        }

        for (CurrencyManipulator manipulator : manipulators) {
            if (manipulator.hasMoney()) {
                String code = manipulator.getCurrencyCode().toUpperCase();
                int totalAmount = manipulator.getTotalAmount();
                ConsoleHelper.writeMessage(code + " - " + totalAmount);
            } else {
                ConsoleHelper.writeMessage("No money available.");
            }
        }

    }
}
