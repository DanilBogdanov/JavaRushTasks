package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

public class StatisticManager {
    private static volatile StatisticManager instance;
    private StatisticStorage statisticStorage = new StatisticStorage();
    private Set<Cook> cooks = new HashSet<>();

    private StatisticManager() {
        
    }

    public static StatisticManager getInstance() {
        if (instance == null) {
            synchronized (StatisticManager.class) {
                if (instance == null) {
                    instance = new StatisticManager();
                }
            }
        }

        return instance;
    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

    public void register(Cook cook) {
        cooks.add(cook);
    }

    public Map<Date, Long> getDateAmount() {
        Map<Date, Long> resultMap = new TreeMap<>();

        List<EventDataRow> list = statisticStorage.getStorage().get(EventType.SELECTED_VIDEOS);

        for (EventDataRow event : list) {
            VideoSelectedEventDataRow videoEvent = (VideoSelectedEventDataRow) event;

            Date date = videoEvent.getDate();
            //Обнулить время для правильной сортировки по дням
            long msInDay = 1000 * 60 * 60 * 24; // Number of milliseconds in a day
            long msPortion = date.getTime() % msInDay;
            date = new Date(date.getTime() - msPortion);


            if (resultMap.containsKey(date)) {
                resultMap.put(date, resultMap.get(date) + videoEvent.getAmount());
            } else {
                resultMap.put(date, videoEvent.getAmount());
            }

        }

        return resultMap;
    }

    //return time in seconds
    public Map<Date, Map<String, Integer>> getCooksTimingDaily() {
        Map<Date, Map<String, Integer>> resultMap = new HashMap<>();

        List<EventDataRow> list = statisticStorage.getStorage().get(EventType.COOKED_ORDER);

        for (EventDataRow event : list) {
            CookedOrderEventDataRow cookEvent = (CookedOrderEventDataRow) event;
            String cookName = cookEvent.getCookName();
            Integer cookTime = cookEvent.getTime();

            Date date = cookEvent.getDate();
            //Обнулить время для правильной сортировки по дням
            long msInDay = 1000 * 60 * 60 * 24; // Number of milliseconds in a day
            long msPortion = date.getTime() % msInDay;
            date = new Date(date.getTime() - msPortion);

            if (resultMap.containsKey(date)) {
                Map<String, Integer> cooksMap = resultMap.get(date);
                if (cooksMap.containsKey(cookName)) {
                    cooksMap.put(cookName, cooksMap.get(cookName) + cookTime);
                } else {
                    cooksMap.put(cookName, cookTime);
                }

                //resultMap.put(date, cooksMap);
            } else {
                Map<String, Integer> cooksMap = new HashMap<>();
                cooksMap.put(cookName, cookTime);
                resultMap.put(date, cooksMap);
            }

        }

        return resultMap;
    }





    private static class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        public Map<EventType, List<EventDataRow>> getStorage() {
            return storage;
        }

        private StatisticStorage() {
            for (EventType type : EventType.values()) {
                storage.put(type, new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data) {
            storage.get(data.getType()).add(data);
        }
    }
}
