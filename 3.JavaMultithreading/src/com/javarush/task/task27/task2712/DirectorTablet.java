package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.statistic.StatisticManager;


import java.text.SimpleDateFormat;
import java.util.*;

public class DirectorTablet {
    public void printAdvertisementProfit() {

        Map<Date, Long> map = StatisticManager.getInstance().getDateAmount();
        double total = 0;
        List<Date> listOfKeys = new ArrayList<>(map.keySet());
        listOfKeys.sort(new Comparator<Date>() {
            @Override
            public int compare(Date o1, Date o2) {
                return o2.compareTo(o1);
            }
        });

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        for (Date date : listOfKeys) {
            double amount = map.get(date) / 100.0;
            total += amount;
            String message = String.format("%s - %.2f",dateFormat.format(date), amount);
            ConsoleHelper.writeMessage(message);
        }

        ConsoleHelper.writeMessage(String.format("Total - %.2f",total));
    }

    public void printCookWorkloading() {
        Map<Date, Map<String, Integer>> cooksDailyMap = StatisticManager.getInstance().getCooksTimingDaily();

        List<Date> dateList = new ArrayList<>(cooksDailyMap.keySet());
        dateList.sort(new Comparator<Date>() {
            @Override
            public int compare(Date o1, Date o2) {
                return o2.compareTo(o1);
            }
        });


        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        for (Date date : dateList) {
            ConsoleHelper.writeMessage(dateFormat.format(date));
            Map<String, Integer> cooksMap = cooksDailyMap.get(date);

        }

    }

    public void printActiveVideoSet() {

    }

    public void printArchivedVideoSet() {

    }

    public static void main(String[] args) {
        DirectorTablet tab = new DirectorTablet();
        tab.printAdvertisementProfit();

    }

}
