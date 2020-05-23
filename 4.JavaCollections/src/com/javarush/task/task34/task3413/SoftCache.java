package com.javarush.task.task34.task3413;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SoftCache {
    private Map<Long, SoftReference<AnyObject>> cacheMap = new ConcurrentHashMap<>();

    public AnyObject get(Long key) {
        SoftReference<AnyObject> softReference = cacheMap.get(key);

        SoftReference<AnyObject> result = cacheMap.get(key);
        if (result != null) {
            return result.get();
        }
        return null;
    }

    public AnyObject put(Long key, AnyObject value) {
        SoftReference<AnyObject> previosAnyObject = cacheMap.put(key, new SoftReference<>(value));

        //напишите тут ваш код
        if (previosAnyObject != null) {
            AnyObject result = previosAnyObject.get();
            previosAnyObject.clear();
            return result;
        }
            return null;
    }

    public AnyObject remove(Long key) {
        SoftReference<AnyObject> softReference = cacheMap.remove(key);

        if (softReference != null) {
            AnyObject result = softReference.get();
            softReference.clear();
            return result;
        }
        return null;
    }
}