package com.jieqing;

public class Heap {

    private int[] items = new int[10];
    private int size;

    public void insert(int value) {
        // Check if array is full
        if (isFull())
            throw new IllegalStateException();

        items[size] = value;
        size++;

        bubbleUp();
    }

    public boolean isFull() {
        return size == items.length;
    }

    private void bubbleUp() {
        // if newItem > parent - bubble up until right position
        int index = size - 1; // index of the last item
        while(index > 0 && items[index] > items[parentOfIndex(index)]) {
            // swap
            swap(index, parentOfIndex(index));
            // reset index to its parent's index
            index = parentOfIndex(index); // index will get smaller and smaller - keep bubbling up
        }
    }

    private int parentOfIndex(int index) {
        return (index - 1) / 2;
    }

    private void swap(int first, int second) {
        int temp = items[first];
        items[first] = items[second];
        items[second] = temp;
    }
}





