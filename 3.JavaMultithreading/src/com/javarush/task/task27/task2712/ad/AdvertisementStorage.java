package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementStorage {
    private static AdvertisementStorage advertisementStorage;

    public static synchronized AdvertisementStorage getInstance() {

            if (advertisementStorage == null) {
                advertisementStorage = new AdvertisementStorage();
            }

        return advertisementStorage;
    }

    private AdvertisementStorage() {
        Object someObject = new Object();
        add(new Advertisement(someObject, "first", 5000, 100, 3 * 60));
        add(new Advertisement(someObject, "second", 100, 10, 15 * 60));
        add(new Advertisement(someObject, "third", 400, 2, 10 * 60));
    }

    private final List<Advertisement> videos = new ArrayList<>();

    public List<Advertisement> list() {
        return videos;
    }

    public void add(Advertisement advertisement) {
        videos.add(advertisement);
    }
}
