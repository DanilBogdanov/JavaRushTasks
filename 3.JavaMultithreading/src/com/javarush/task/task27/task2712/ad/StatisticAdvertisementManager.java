package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticAdvertisementManager {
    private AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private static volatile StatisticAdvertisementManager instance;

    private StatisticAdvertisementManager() {

    }

    public static StatisticAdvertisementManager getInstance() {
        if (instance == null) {
            synchronized (StatisticAdvertisementManager.class) {
                if (instance == null) {
                    instance = new StatisticAdvertisementManager();
                }
            }
        }

        return instance;
    }

    public List<Advertisement> getActiveVideo() {
        List<Advertisement> resultList = new ArrayList<>();

        for (Advertisement ad : storage.list()) {
            if (ad.getHits() > 0) {
                resultList.add(ad);
            }
        }

        return resultList;
    }

    public List<Advertisement> getArchivedVideo() {
        List<Advertisement> resultList = new ArrayList<>();

        for (Advertisement ad : storage.list()) {
            if (ad.getHits() == 0) {
                resultList.add(ad);
            }
        }

        return resultList;
    }
}
