package com.jieqing;

import java.util.Arrays;

public class PriorityQueue {

    private int[] items = new int[5];
    private int count; // count in queue

    // Iterate from the end and find a position to insert the item
    public void add(int item) {
        if (isFull())
            throw new IllegalStateException();
        // i.e. 5 items in queue, count = 5, index of last = 4
        int i = shiftItemsToInsert(item);
        items[i] = item;
        count++;
    }

    public boolean isFull() {
        return count == items.length;
    }

    public int shiftItemsToInsert(int item) {
        // Shifting items
        // [2, 3, 6, 7, 9, 12]
        // Insert 8?
        int i;
        for (i = count - 1; i >= 0; i--) {
            if (items[i] > item) {
                items[i + 1] = items[i];
            } else
                break; // exit the for loop
        }
        return i + 1;
    }

    // Can be used to remove and print to the console
    public int remove() {
        if (isEmpty())
            throw new IllegalStateException();

        count--; // 4
        return items[count]; // items[4] - the last ele
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
















