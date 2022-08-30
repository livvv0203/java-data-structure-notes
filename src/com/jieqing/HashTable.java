package com.jieqing;

import java.util.LinkedList;

public class HashTable {

    private class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] entries = new LinkedList[5];

    public void put(int key, String value) {
        int index = hash(key);
        if (entries[index] == null)
            entries[index] = new LinkedList<>();
        for (Entry entry : entries[index]) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }
        entries[index].addLast(new Entry(key, value));
    }

    public String get(int key) {
        int index = hash(key);
        if (entries[index] != null) {
            for (Entry entry : entries[index])
                if (entry.key == key)
                    return entry.value;
        }
        return null;
    }

    private int hash(int key) {
        return key % entries.length;
    }
}
