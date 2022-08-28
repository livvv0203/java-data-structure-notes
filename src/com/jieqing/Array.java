package com.jieqing;

public class Array {

    private int[] items;
    private int count;

    public Array(int length) {
        items = new int[length];
    }

    public void insert(int item) {
        // If the array if full, resize it
        if(items.length == count) {
            // Create a new array (twice the size)
            int[] newItems = new int[count * 2];
            // Copy all existing items in array
            for (int i = 0; i < count; i++) {
                newItems[i] = items[i];
            }
            // Set "items" to this new array
            items = newItems;
        }
        // Add the new item to the end
        items[count] = item; // OR: items[count++] = item
        count++;
    }

    public void removeAt(int index) {
        // Validate the index - count = 4, index of last = 3
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException();
        }
        // Shift items to the left to fill the hole
        for (int i = index; i < count; i++) {
            items[i] = items[i + 1];
        }
        count--; // Total number of items current in the array
    }

    // Best case: O(1) Worst: O(n)
    public int indexOf(int item) {
        for (int i = 0; i < count; i++) {
            if (items[i] == item)
                return i;
        }
        return -1; // Not found
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }
}





