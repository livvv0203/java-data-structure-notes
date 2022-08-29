package com.jieqing;

import sun.awt.util.IdentityLinkedList;

import java.util.NoSuchElementException;

public class LinkedList {
    /**
     * Node Class declared inside the LinkedList class
     */
    private class Node {
        private int value;
        private Node next; // Reference to the next Node
        // Construct a Node with value
        // This is a custom constructor
        public Node(int value) {
            this.value = value;
        }
    }

    private Node first; // Head Node
    private Node last; // Tail Node
    private int size;

    public void addLast(int item) {
        Node node = new Node(item);

        if (isEmpty()) {
            first = last = node;
        } else {
            last.next = node; // linking last node to the new node
            last = node; // Update last to point to the new node
        }

        size++;
    }

    public void addFirst(int item) {
        Node node = new Node(item);

        if (isEmpty()) {
            first = last = node;
        } else {
            node.next = first; // link
            first = node; // update
        }

        size++;
    }

    public void removeFirst() {
        // [10 -> 20 -> 30]
        // Link list is empty
        if (isEmpty())
            throw new NoSuchElementException();
        // Only one node
        if (first == last) {
            first = last = null;
            return;
        }
        // At least 2 nodes
        Node second = first.next; // point to 20, as a backup
        first.next = null; // this will remove the link between 10 and 20
        first = second; // update first

        size--;
    }

    public void removeLast() {
        // List is empty
        if (isEmpty())
            throw new NoSuchElementException();
        // Only 1 node, there's no prev exist
        if (first == last) {
            first = last = null;
        } else {
            // At least 2 nodes
            // [10 -> 20 -> 30]
            // previous -> 20, last -> 30
            Node previous = getPrevious(last);
            // Make last to point previous
            last = previous; // this will shrink list
            last.next = null; // remove the link
        }
        size--;
    }

    private Node getPrevious(Node node) {
        Node current = first;
        while(current != null) {
            // Found the prev node
            if (current.next == node) return current;
            current = current.next;
        }
        return null;
    }

    public int indexOf(int item) {
        int index = 0;
        Node currentNode = first;
        // As traversing the list, increment index
        while(currentNode != null) {
            if (currentNode.value == item) return index;
            // otherwise,
            currentNode = currentNode.next;
            index++;
        }
        return -1;
    }
    // O(1)
    public int size() {
        return size;
    }

    public int[] toArray() {
        int[] array = new int[size];
        // Traverse the list, add each node to array
        Node current = first;
        int index = 0;
        while(current != null) {
            array[index] = current.value;
            index++;
            current = current.next; // set current to reference the next node
        }
        return array;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    private boolean isEmpty() {
        return first == null;
    }

    /**
     * Reverse the Linked List
     */
    public void reverse() {
        if (isEmpty())
            return;
        // [10 -> 20 -> 30]
        // prev current next
        // [10 <- 20 <- 30]
        Node previous = first;
        Node current = first.next;

        while(current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        last = first;
        last.next = null;
        first = previous;
    }

    /**
     * Find kth Node from the end of the linked list in one pass
     */
    public int getKthFromTheEnd(int k) {

        if (isEmpty())
            throw new IllegalStateException();

        // Needs two pointers
        Node p1 = first;
        Node p2 = first;
        for (int i = 0; i < k - 1; i++) {
            p2 = p2.next; // moving the second pointer forward by k - 1 distance
            if (p2 == null)
                throw new IllegalArgumentException(); // k is too large
        }
        while(p2 != last) {
            // Move both of the two pointers forward
            p1 = p1.next;
            p2 = p2.next; // until p2 is referencing the last node
        }
        return p1.value;
    }
}








