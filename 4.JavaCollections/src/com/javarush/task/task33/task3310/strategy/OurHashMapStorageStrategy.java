package com.javarush.task.task33.task3310.strategy;

public class OurHashMapStorageStrategy implements StorageStrategy {
    /*Добавь и реализуй класс OurHashMapStorageStrategy, используя класс Entry из предыдущей подзадачи. Класс OurHashMapStorageStrategy должен реализовывать интерфейс StorageStrategy.

     */
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];
    private int size;
    private int threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
    private float loadFactor = DEFAULT_LOAD_FACTOR;

    private int hash(Long k) {
        int h;
        return (k == null) ? 0 : (h = k.hashCode()) ^ (h >>> 16);
    }

    private int indexFor(int hash, int length) {
        return hash & (length - 1);
    }

    private Entry getEntry(Long key) {
        /*int index = indexFor(hash(key), table.length);
        Entry entry = table[index];
        if (entry != null) {
            if (entry.getKey().equals(key)) {
                return entry;
            }
            while (entry.next != null) {
                entry = entry.next;
                if (entry.getKey().equals(key)) {
                    return entry;
                }
            }
        }
        return null;*/

        int hash = (key == null) ? 0 : hash(key);
        for (Entry e = table[indexFor(hash, table.length)];
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
        Entry[] oldTable = table;
        int oldCapacity = oldTable.length;

        Entry[] newTable = new Entry[newCapacity];
        transfer(newTable);
        table = newTable;
        threshold = (int)(newCapacity * loadFactor);
    }

    private void transfer(Entry[] newTable) {
        Entry[] src = table;
        int newCapacity = newTable.length;
        for (int j = 0; j < src.length; j++) {
            Entry e = src[j];
            if (e != null) {
                src[j] = null;
                do {
                    Entry next = e.next;
                    int i = indexFor(e.hash, newCapacity);
                    e.next = newTable[i];
                    newTable[i] = e;
                    e = next;
                } while (e != null);
            }
        }
    }

    private void addEntry(int hash, Long key, String value, int bucketIndex) {
        Entry e = table[bucketIndex];
        table[bucketIndex] = new Entry(hash, key, value, e);
        if (size++ >= threshold)
            resize(2 * table.length);
    }

    private void createEntry(int hash, Long key, String value, int bucketIndex) {
        Entry e = table[bucketIndex];
        table[bucketIndex] = new Entry(hash, key, value, e);
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

        Entry[] tab = table;
        for (int i = 0; i < tab.length ; i++)
            for (Entry e = tab[i] ; e != null ; e = e.next)
                if (value.equals(e.value))
                    return true;
        return false;

    }

    @Override
    public void put(Long key, String value) {
        int hash = hash(key);
        int i = indexFor(hash, table.length);
        for (Entry e = table[i]; e != null; e = e.next) {
            Object k;
            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {

                e.value = value;

            }
        }

        addEntry(hash, key, value, i);
    }

    @Override
    public Long getKey(String value) {
        for (Entry entry : table) {
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
        for (Entry e = table[indexFor(hash, table.length)];
             e != null;
             e = e.next) {
            Object k;
            if (e.hash == hash && ((k = e.key) == key || key.equals(k)))
                return e.value;
        }
        return null;
    }
}
