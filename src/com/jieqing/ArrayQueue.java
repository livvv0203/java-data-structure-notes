package com.jieqing;

import java.util.Arrays;

// Basic implementation using array
public class ArrayQueue {

    private int[] items;
    private int rear;
    private int front;
    private int count;

    public ArrayQueue(int capacity) {
        items = new int[capacity];
    }

    public void enqueue(int item) {
        if (count == items.length)
            throw new IllegalStateException();
        items[rear] = item;
        // rear++;
        rear = (rear + 1) % items.length;
        count++;
    }

    public int dequeue() {
        int item = items[front];
        items[front] = 0; // to clear
        front++;
        front = (front + 1) % items.length;
        count--;
        return item; // increment front pointer
    }

    /**
     * Circular Array
     * [0, 0, 30, 40, 50]
     * [60, 70, 30, 40, 50]
     * 5  R(6)
     * Rear -> 5 -> 0
     * 6 -> 1
     * 7 -> 2
     * (rear + 1) % length
     *
     * @return
     */

    @Override
    public String toString() {
        return Arrays.toString(items);
    }

}




