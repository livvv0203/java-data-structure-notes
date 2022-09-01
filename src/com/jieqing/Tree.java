package com.jieqing;
import java.util.ArrayList;

public class Tree {

    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node = " + value;
        }
    }

    private Node root;

    public void insert(int value) {

        Node node = new Node(value);

        if (root == null) {
            root = node;
            return;
        }

        Node current = root;
        // Traverse the tree
        while (true) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    break; // out of loop
                }
                // go to left subtree
                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    // found parent of new node
                    current.rightChild = node;
                    break;
                }
                // go to right subtree
                current = current.rightChild;
            }
        }
    }

    public boolean find(int value) {
        Node current = root;
        // Traverse the tree
        while (current != null) {
            if (value < current.value)
                current = current.leftChild;
            else if (value > current.value)
                current = current.rightChild;
            else
                return true; // found value node
        }
        return false;
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    /**
     * Root -> Left -> Right
     *
     * @param root
     */
    private void traversePreOrder(Node root) {
        // Base condition
        if (root == null)
            return;
        // visit root (print value)
        System.out.println(root.value);
        // visit left
        traversePreOrder(root.leftChild);
        // visit right
        traversePreOrder(root.rightChild);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    /**
     * Left -> Root -> Right
     *
     * @param root
     */
    private void traverseInOrder(Node root) {
        if (root == null)
            return;

        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    /**
     * Left -> Right -> Root
     *
     * @param root
     */
    private void traversePostOrder(Node root) {
        if (root == null)
            return;

        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        // empty tree
        if (root == null)
            return -1;
        // reach a leaf node
        if (isLeaf(root))
            return 0;

        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    public int min() {
        return min(root);
    }

    // Find minimum value in a binary tree O(n)
    private int min(Node root) {
        // Base Condition - get to the leaf node
        if (isLeaf(root))
            return root.value; // exit recursion

        int left = min(root.leftChild);
        int right = min(root.rightChild);

        return Math.min(Math.min(left, right), root.value);
    }

    private boolean isLeaf(Node root) {
        return root.leftChild == null & root.rightChild == null;
    }

    // Find minimum value in a binary search tree - O(Log n)
    public int minimum() {
        if (root == null)
            throw new IllegalStateException();

        Node current = root;
        Node last = current;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last.value;
    }

    public boolean equals(Tree other) {
        if (other == null)
            return false;

        return equals(root, other.root);
    }

    private boolean equals(Node first, Node second) {
        if (first == null && second == null) return true;

        // PreOrder Traversal
        if (first != null && second != null) {
            return first.value == second.value
                    && equals(first.leftChild, second.leftChild)
                    && equals(first.rightChild, second.rightChild);
        }
        return false;
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    // Testing purpose - messing up the order of the binary search tree
    public void swapRoot() {
        Node temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
    }

    private boolean isBinarySearchTree(Node root, int min, int max) {
        if (root == null) {
            return true;
        }
        // out of range
        if (root.value < min || root.value > max)
            return false;

        // If root is 20, right child should be 21 or greater, left child should be 19 or less
        return isBinarySearchTree(root.leftChild, min, root.value - 1)
                && isBinarySearchTree(root.rightChild, root.value + 1, max);
    }

    public ArrayList<Integer> getNodesAtDistance(int distance) {
        ArrayList<Integer> list = new ArrayList<>();

        getNodesAtDistance(root, distance, list);
        return list;
    }

    private void getNodesAtDistance(Node root, int distance, ArrayList<Integer> list) {
        if (root == null)
            return; // do nothing

        if (distance == 0) {
            list.add(root.value);
            return;
        }
        // Recursively traverse the tree
        getNodesAtDistance(root.leftChild, distance - 1, list);
        getNodesAtDistance(root.rightChild, distance - 1, list);
    }

    public void traverseLevelOrder() {
        for (int i = 0; i <= height(); i++) {
            for (int value : getNodesAtDistance(i)) {
                System.out.println(value);
            }
        }
    }
}



































