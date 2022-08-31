package com.jieqing;

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
        while(true) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    break; // out of loop
                }
                // go to left subtree
                current = current.leftChild;
            }
            else {
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
        while(current != null) {
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
     * @param root
     */
    private void traversePostOrder(Node root) {
        if (root == null)
            return;

        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }
}












