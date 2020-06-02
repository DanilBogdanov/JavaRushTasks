package com.javarush.task.task34.task3408;

import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();   //T

    public V getByKey(K key, Class<V> clazz) throws Exception {
        //
        V reference = cache.get(key);
        if (reference == null) {
            Constructor<V> constructor = clazz.getDeclaredConstructor(key.getClass());

            //constructor.setAccessible(true);
            V val = constructor.newInstance(key);
            cache.put(key, val);
            return val;

        }
        return reference;
    }

    public boolean put(V obj) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //
        try {
            Method method = obj.getClass().getDeclaredMethod("getKey");
            method.setAccessible(true);

            K key = (K) method.invoke(obj);
            cache.put(key, obj);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int size() {
        return cache.size();
    }
}
