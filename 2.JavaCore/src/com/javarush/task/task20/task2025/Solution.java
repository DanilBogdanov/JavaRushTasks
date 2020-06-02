package com.javarush.task.task20.task2025;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
        ArrayList<Long> resultArray = new ArrayList<>();
        List<ArrayList<Long>> degreeList = new ArrayList<>();// 0-19

        //intialize list degree
        for (int i = 0; i < 20; i++) {
            degreeList.add(new ArrayList<>());
        }
        for (int i = 0; i < 20; i++) {
            for (int y = 0; y < 10; y++) {
                degreeList.get(i).add((long) Math.pow(y, i));
            }
        }

        BigInteger summOfDigits;
        long digits;
        int degree;
        int digit;

        for (long i = 1; i < N; i++) {
            degree = Long.toString(i).length();
            summOfDigits = BigInteger.ZERO;
            digits = i;

            while (digits > 0) {
                digit = (int) digits % 10;
                digits = digits / 10;
                summOfDigits = summOfDigits.add(BigInteger.valueOf(degreeList.get(degree).get(digit)));
            }

            if (i == summOfDigits.longValue()) {
                resultArray.add(i);
            }
        }


        long[] result = new long[resultArray.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultArray.get(i);
        }
        return result;

    }

    public static void main(String[] args) {
        Date start = new Date();
        //long[] numbers = getNumbers(123456789L);
        long[] numbers = test(12345678L);
        System.out.println("-*/-*/-*/-*/-*/-*/-*/-*/-*/-*/TEST");

//        for (long n : numbers) {
//            System.out.println(n);
//        }
        Date stop = new Date();

        System.out.println("full time - " + ((stop.getTime() - start.getTime()) / 1000.0d));
    }

    public static long[] test(long N) {
        double timeOfLoop = 0;
        Date startLoop;
        Date stopLoop;
        ArrayList<Long> resultArray = new ArrayList<>();
        List<ArrayList<Long>> degreeList = new ArrayList<>();// 0-19

        //intialize list degree
        {
            for (int i = 0; i < 20; i++) {
                degreeList.add(new ArrayList<>());
            }
            for (int i = 0; i < 20; i++) {
                for (int y = 0; y < 10; y++) {
                    degreeList.get(i).add((long) Math.pow(y, i));
                }
            }
        }


        long summOfDigits;
        long digits;
        ArrayList<Integer> digitsList = new ArrayList<>();
        int degree;
        int digit;
        System.out.println("*************StartParsing************");
        for (long i = 1; i < N; i++) {
            summOfDigits = 0;
            digits = i;
            digitsList = new ArrayList<>();

            while (digits > 0) {
                digit = (int) digits % 10;
                digits = digits / 10;
                digitsList.add(digit);
            }

            degree = digitsList.size();

            for (Integer dig : digitsList) {
                summOfDigits += degreeList.get(degree).get(dig);
            }
            if (i == summOfDigits) {
                resultArray.add(i);
            }
        }

        //startLoop = new Date(); //
        //stopLoop = new Date();//
        //timeOfLoop += (stopLoop.getTime() - startLoop.getTime());//T
        System.out.println(timeOfLoop / 1000 + "sec of loop");
        System.out.println("*********Stop Parsing**********");

        long[] result = new long[resultArray.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultArray.get(i);
        }
        return result;

    }
}
