package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> result = new HashSet<>();

        for (String s : strings) {
            result.add(shortener.getId(s));
        }

        return result;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> result = new HashSet<>();
        for (Long k : keys) {
            result.add(shortener.getString(k));
        }
        return result;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> testSet = new HashSet<>();
        for (long i = 0; i < elementsNumber; i++) {
            testSet.add(Helper.generateRandomString());
        }
        Shortener shortener = new Shortener(strategy);

        Date start = new Date();
        Set<Long> ids = getIds(shortener, testSet);
        Date finish = new Date();
        long timeToId = finish.getTime() - start.getTime();
        Helper.printMessage("Time to Ids: " + timeToId + "ms");

        start = new Date();
        Set<String> strings = getStrings(shortener, ids);
        finish = new Date();
        long timeToString = finish.getTime() - start.getTime();
        Helper.printMessage("Time to Strings: " + timeToString + "ms");

        if (testSet.size() != strings.size()) {
            Helper.printMessage("Тест не пройден.");
        } else {
            Helper.printMessage("Тест пройден.");
        }
    }

    public static void main(String[] args) {
        int countOfTests = 50_000;
        //testStrategy(new HashMapStorageStrategy(), countOfTests);
        //testStrategy(new OurHashMapStorageStrategy(), countOfTests);
        //testStrategy(new FileStorageStrategy(), 10);
        testStrategy(new OurHashBiMapStorageStrategy(), countOfTests);
        testStrategy(new HashBiMapStorageStrategy(), countOfTests);
        testStrategy(new DualHashBidiMapStorageStrategy(), countOfTests);
    }
}
