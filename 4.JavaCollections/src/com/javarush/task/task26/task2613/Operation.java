package com.javarush.task.task26.task2613;

public enum Operation {
    INFO,
    DEPOSIT,
    WITHDRAW,
    EXIT;

    public static Operation getAllowableOperationByOrdinal(Integer i) {
        if (i == null || i > Operation.values().length || i < 1) {
            throw new IllegalArgumentException();
        }
        return Operation.values()[i - 1];
    }
}
