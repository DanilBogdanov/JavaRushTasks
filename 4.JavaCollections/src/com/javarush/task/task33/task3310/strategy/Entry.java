package com.javarush.task.task33.task3310.strategy;

import java.io.Serializable;

public class Entry implements Serializable {
    Long key;
    String value;
    Entry next;
    int hash;

    public Entry(int hash, Long key, String value, Entry next) {
        this.key = key;
        this.value = value;
        this.next = next;
        this.hash = hash;
    }

    public Long getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return key + "=" + value;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (int)(key ^ (key >>> 32));
        result = 31 * result + value.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        return (this.key.equals(entry.key) && (this.value.equals(entry.value)));
    }
}
