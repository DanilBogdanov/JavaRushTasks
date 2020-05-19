package com.javarush.task.task34.task3412;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/* 
Добавление логирования в класс
*/

public class Solution {
    private static final Logger logger = LoggerFactory.getLogger(Solution.class);

    private int value1;
    private String value2;
    private Date value3;

    public Solution(int value1, String value2, Date value3) {
        logger.debug("create solution val1-{} val2-{} val3-{}", value1, value2, value3);
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }

    public static void main(String[] args) {

        Solution sol = new Solution(1, "", new Date());
        sol.divide(4,0);
        sol.calculateAndSetValue3(56);
    }

    public void calculateAndSetValue3(long value) {
        logger.trace("calculating and set val 3 - {}",value);
        value -= 133;
        if (value > Integer.MAX_VALUE) {
            value1 = (int) (value / Integer.MAX_VALUE);
            logger.debug("calcul by divading {}/max int", value);

        } else {
            value1 = (int) value;
            logger.debug("calcul and set val3 - {}", value);
        }
    }

    public void printString() {
        logger.trace("print val2");
        if (value2 != null) {
            System.out.println(value2.length());
        }
    }

    public void printDateAsLong() {
        logger.trace("print val3");
        if (value3 != null) {
            System.out.println(value3.getTime());
        }
    }

    public void divide(int number1, int number2) {
        logger.trace("divade {}/{}", number1, number2);
        try {

            System.out.println(number1 / number2);
        } catch (ArithmeticException e) {
            logger.error("divide", e);
        }
    }

    public void setValue1(int value1) {
        logger.debug("set first val - {}", value1);
        this.value1 = value1;
    }

    public void setValue2(String value2) {
        logger.debug("set second val - {}", value2);
        this.value2 = value2;
    }

    public void setValue3(Date value3) {
        logger.debug("set third val - {}", value3);
        this.value3 = value3;
    }
}
