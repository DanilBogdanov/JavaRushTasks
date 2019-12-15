package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;


import java.text.SimpleDateFormat;
import java.util.*;

public class DirectorTablet {
    private Comparator<Advertisement> advertisementComparator = new Comparator<Advertisement>() {
        @Override
        public int compare(Advertisement o1, Advertisement o2) {
            return o1.getName().compareToIgnoreCase(o2.getName());
        }};

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
        StringBuffer message = new StringBuffer();
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
            if (message.length() > 0) {
                message.append("\n");
            }

            message.append(dateFormat.format(date) + "\n");
            Map<String, Integer> cooksMap = cooksDailyMap.get(date);
            List<String> keyList = new ArrayList<>(cooksMap.keySet());
            keyList.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });

            //Math.ceil() in big
            for (String cookName : keyList) {
                //int cookTime = (int) Math.ceil(cooksMap.get(cookName) / 60.0);
                int cookTime = cooksMap.get(cookName) ;
                message.append(String.format("%s - %d min", cookName, cookTime));
                message.append("\n");
            }
        }

        ConsoleHelper.writeMessage(message.toString());
    }

    public void printActiveVideoSet() {
        List<Advertisement> activeVideoList = StatisticAdvertisementManager.getInstance().getActiveVideo();
        activeVideoList.sort(advertisementComparator);

        for (Advertisement ad : activeVideoList) {
            ConsoleHelper.writeMessage(String.format("%s - %s", ad.getName(), ad.getHits()));
        }
    }

    public void printArchivedVideoSet() {
        List<Advertisement> archiveVideoList = StatisticAdvertisementManager.getInstance().getArchivedVideo();
        archiveVideoList.sort(advertisementComparator);

        for (Advertisement ad : archiveVideoList) {
            ConsoleHelper.writeMessage(ad.getName());
        }
    }

    public static void main(String[] args) {
        DirectorTablet tab = new DirectorTablet();
        tab.printAdvertisementProfit();

    }



}
