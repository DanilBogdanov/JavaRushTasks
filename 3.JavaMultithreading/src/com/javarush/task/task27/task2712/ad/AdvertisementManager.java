package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.NoAvailableVideoEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        if (storage.list().isEmpty()) {
            NoAvailableVideoEventDataRow noAvailableVideoEventDataRow =
                    new NoAvailableVideoEventDataRow(timeSeconds);
            StatisticManager.getInstance().register(noAvailableVideoEventDataRow);
            throw new NoVideoAvailableException();
        }

        List<List<Advertisement>> listOfAvailableVariables = getAvailableVariables(storage.list());
        sortVariablesList(listOfAvailableVariables);

        List<Advertisement> listToShow = listOfAvailableVariables.get(0);
        sortListToShow(listToShow);

        if (listToShow.size() > 0) {
            VideoSelectedEventDataRow event = new VideoSelectedEventDataRow(listToShow, getAmountOfSetVideos(listToShow),
                    getDurationOfSetVideos(listToShow));
            StatisticManager.getInstance().register(event);
        }

        for (Advertisement ad : listToShow) {
            ConsoleHelper.writeMessage(ad.toString());
            ad.revalidate();
        }

    }

    private long getAmountOfSetVideos(List<Advertisement> list) {
        long result = 0;

        for (Advertisement ad : list) {
            result += ad.getAmountPerOneDisplaying();
        }

        return result;
    }

    private int getDurationOfSetVideos(List<Advertisement> list) {
        int result = 0;

        for (Advertisement ad : list) {
            result += ad.getDuration();
        }

        return result;
    }

    private List<List<Advertisement>> getAvailableVariables(List<Advertisement> sourceList) {
        List<List<Advertisement>> result = new ArrayList<>();

        for (Advertisement ad : sourceList) {
            if (ad.getHits() > 0) {
                List<Advertisement> newSourceList = new ArrayList<>(sourceList);
                newSourceList.remove(ad);
                List<Advertisement> newResultList = new ArrayList<>();
                newResultList.add(ad);
                result.addAll(getAvailableVariables(newSourceList, newResultList, ad.getDuration()));
            }
        }

        return result;
    }

    private List<List<Advertisement>> getAvailableVariables (List<Advertisement> sourceList,
                                                List<Advertisement> resultList, int currentDuration) {
        List<List<Advertisement>> result = new ArrayList<>();

        for (Advertisement ad : sourceList) {
            if (ad.getHits() > 0) {
                List<Advertisement> newResultList = new ArrayList<>(resultList);
                newResultList.add(ad);
                int newCurrentDuration = currentDuration + ad.getDuration();

                if (newCurrentDuration > timeSeconds) {
                    continue;
                }

                List<Advertisement> newSourceList = new ArrayList<>(sourceList);
                newSourceList.remove(ad);
                result.addAll(getAvailableVariables(newSourceList, newResultList, newCurrentDuration));
            }
        }

        if (currentDuration <= timeSeconds) {
            result.add(resultList);
        }

        return result;
    }

    private void sortVariablesList (List<List<Advertisement>> list) {
        Comparator <List<Advertisement>> maxSummComparator = (a, b) -> {
            int summA = 0;
            int summB = 0;

            for (Advertisement ad : a) {
                summA += ad.getAmountPerOneDisplaying();
            }

            for (Advertisement ad : b) {
                summB += ad.getAmountPerOneDisplaying();
            }
            return Integer.compare(summA, summB) * -1;
        };

        Comparator <List<Advertisement>> maxTiming = (a, b) -> {
            int timingA = 0;
            int timingB = 0;

            for (Advertisement ad : a) {
                timingA += ad.getDuration();
            }

            for (Advertisement ad : b) {
                timingB += ad.getDuration();
            }

            return Integer.compare(timingA, timingB) * -1;
        };

        Comparator<List<Advertisement>> finalComparator = maxSummComparator.thenComparing(maxTiming).thenComparing(adv -> adv.size());
        list.sort(finalComparator);
    }

    private void sortListToShow(List<Advertisement> list) {

        Comparator<Advertisement> comparator = Comparator.comparing(ad -> ad.getAmountPerOneDisplaying() * -1);
        comparator = comparator.thenComparing(Comparator.comparingDouble(ad -> ad.getAmountPerOneDisplaying() / ad.getDuration()));

        list.sort(comparator);
    }



}
