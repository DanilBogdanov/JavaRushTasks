package com.javarush.task.task33.task3310.strategy;

public class OurHashMapStorageStrategy implements StorageStrategy {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];
    private int size;
    private int threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
    private float loadFactor = DEFAULT_LOAD_FACTOR;

    private int hash(Long k) {
        return 0;
    }

    private int indexFor(int hash, int length) {
        return 0;
    }

    private Entry getEntry(Long key) {
        return null;
    }

    private void resize() {

    }

    private void transfer(Entry[] newTable) {

    }

    private void addEntry(int hash, Long key, String value, int bucketIndex) {

    }

    private void createEntry(int hash, Long key, String value, int bucketIndex) {

    }

    @Override
    public boolean containsKey(Long key) {
        return false;
    }

    @Override
    public boolean containsValue(String value) {
        return false;
    }

    @Override
    public void put(Long key, String value) {

    }

    @Override
    public Long getKey(String value) {
        return null;
    }

    @Override
    public String getValue(Long key) {
        return null;
    }
}
