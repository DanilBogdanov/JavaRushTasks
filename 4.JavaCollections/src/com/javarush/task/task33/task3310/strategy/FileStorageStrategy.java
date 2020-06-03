package com.javarush.task.task33.task3310.strategy;

import java.io.File;

public class FileStorageStrategy implements StorageStrategy {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
    static final long DEFAULT_BUCKET_SIZE_LIMIT = 10_000;
    private int size;
    private long bucketSizeLimit = DEFAULT_BUCKET_SIZE_LIMIT;
    long maxBucketSize = DEFAULT_BUCKET_SIZE_LIMIT;

    public FileStorageStrategy() {
        initializeTab(table);
    }

    public long getBucketSizeLimit() {
        return bucketSizeLimit;
    }

    public void setBucketSizeLimit(long bucketSizeLimit) {
        this.bucketSizeLimit = bucketSizeLimit;
    }

    private int hash(Long k) {
        int h;
        return (k == null) ? 0 : (h = k.hashCode()) ^ (h >>> 16);
    }

    private int indexFor(int hash, int length) {
        return hash & (length - 1);
    }

    private Entry getEntry(Long key) {
        int hash = (key == null) ? 0 : hash(key);
        for (Entry e = table[indexFor(hash, table.length)].getEntry();
             e != null;
             e = e.next) {
            Object k;
            if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))
                return e;
        }
        return null;
    }

    private void resize(int newCapacity) {
        FileBucket[] oldTable = table;
        int oldCapacity = oldTable.length;
        FileBucket[] newTable = new FileBucket[newCapacity];
        initializeTab(newTable);
        transfer(newTable);
        table = newTable;
    }

    private void transfer(FileBucket[] newTable) {
        FileBucket[] src = table;
        int newCapacity = newTable.length;
        for (int j = 0; j < src.length; j++) {
            Entry e = src[j].getEntry();

            if (e != null) {
                src[j].remove();
                do {
                    Entry next = e.next;
                    int i = indexFor(e.hash, newCapacity);
                    e.next = newTable[i].getEntry();
                    newTable[i].putEntry(e);
                    e = next;
                } while (e != null);
            }
        }
    }

    private void addEntry(int hash, Long key, String value, int bucketIndex) {
        Entry e = table[bucketIndex].getEntry();
        table[bucketIndex].putEntry(new Entry(hash, key, value, e));
        if (table[bucketIndex].getFileSize() > bucketSizeLimit) {
            resize(2 * table.length);
            size++;
        }
    }

    private void createEntry(int hash, Long key, String value, int bucketIndex) {
        Entry e = table[bucketIndex].getEntry();
        table[bucketIndex].putEntry(new Entry(hash, key, value, e));
        size++;
    }

    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        if (value == null)
            return false;

        FileBucket[] tab = table;
        for (int i = 0; i < tab.length ; i++)
            for (Entry e = tab[i].getEntry() ; e != null ; e = e.next)
                if (value.equals(e.value))
                    return true;
        return false;

    }

    @Override
    public void put(Long key, String value) {
        int hash = hash(key);
        int i = indexFor(hash, table.length);
        for (Entry e = table[i].getEntry(); e != null; e = e.next) {
            Object k;
            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {

                e.value = value;

            }
        }

        addEntry(hash, key, value, i);
    }

    @Override
    public Long getKey(String value) {
        for (FileBucket fb : table) {
            Entry entry = fb.getEntry();
            if (entry != null) {
                if (entry.getValue().equals(value)) {
                    return entry.getKey();
                }
                if (entry.next != null) {
                    Entry nextEntry = entry.next;
                    while (nextEntry != null) {
                        if (nextEntry.getValue().equals(value)) {
                            return nextEntry.getKey();
                        }
                        nextEntry = nextEntry.next;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        //return getEntry(key).getValue();

        if (key == null)
            return null;
        int hash = hash(key);
        for (Entry e = table[indexFor(hash, table.length)].getEntry();
             e != null;
             e = e.next) {
            Object k;
            if (e.hash == hash && ((k = e.key) == key || key.equals(k)))
                return e.value;
        }
        return null;
    }

    private void initializeTab(FileBucket[] fileBucket) {
        for (int i = 0; i < fileBucket.length; i++) {
            fileBucket[i] = new FileBucket();
        }
    }
}
