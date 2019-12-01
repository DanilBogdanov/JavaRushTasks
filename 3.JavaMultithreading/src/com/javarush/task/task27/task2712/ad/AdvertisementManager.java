package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;


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
            throw new NoVideoAvailableException();
        }

        List<List<Advertisement>> listOfAvailableVariables = getAvailableVariables(storage.list());
        sortVariablesList(listOfAvailableVariables);

        List<Advertisement> listToShow = listOfAvailableVariables.get(0);
        sortListToShow(listToShow);

        for (Advertisement ad : listToShow) {
            ConsoleHelper.writeMessage(ad.toString());
            ad.revalidate();
        }

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


    //todo========================
    public static void main(String[] args) {
        AdvertisementStorage storage = AdvertisementStorage.getInstance();
        AdvertisementManager manager = new AdvertisementManager(60 * 30);
        AdvertisementManager manager1 = new AdvertisementManager(60 * 30);
        AdvertisementManager manager2 = new AdvertisementManager(60 * 30);

        manager.processVideos();
        System.out.println();
        manager1.processVideos();
        System.out.println();
        manager2.processVideos();
        System.out.println();
        manager2.processVideos();
    }
}
