package com.jieqing;

import sun.security.rsa.RSAUtil;

public class AVLTree {

    // AVLNode class
    private class AVLNode {
        private int value;
        private int height;
        private AVLNode leftChild;
        private AVLNode rightChild;

        public AVLNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Value = " + this.value;
        }
    }

    // Field of com.jieqing.AVLTree Class
    private AVLNode root;

    public void insert(int value) {
        root = insert(root, value);
    }

    private AVLNode insert(AVLNode root, int value) {

        if (root == null)
            return new AVLNode(value);

        // Tree is not empty - find a right place to insert the new node
        if (value < root.value)
            // Go to the left side, recursively
            root.leftChild = insert(root.leftChild, value);
        else
            root.rightChild = insert(root.rightChild, value);

        // root.height = MAX(left, right) + 1
        root.height = Math.max(height(root.leftChild), height(root.rightChild)) + 1;
        // simply call the balance method
        balance(root);

        return root;
    }

    private void balance(AVLNode node) {
        // Check if the tree is balanced
        // Compare height of the left and right subtree
        // Concept of Balance Factor = height(L) - height(R)
        // balanceFactor > 1 Tree is Left Heavy -> Perform a right rotation
        // i.e. 3 - 5 = -2 -> right heavy -> balanceFactor < -1
        if (isLeftHeavy(root)) {
            if (balanceFactor(root.leftChild) < 0)
                System.out.println("Left rotate " + root.leftChild.value);
            System.out.println("Right rotate " + root.rightChild.value);
        }
        else if (isRightHeavy(root)) {
            if (balanceFactor(root.rightChild) > 0)
                System.out.println("Right rotate " + root.rightChild.value);
            System.out.println("Left rotate " + root.leftChild.value);
        }
    }

    /**
     * Right-skew Tree - do a left rotate on 10
     * make 10 the left child of 20
     * 10
     *   20
     *     30
     * @param node
     * @return
     */
    private boolean isLeftHeavy(AVLNode node) {
        return balanceFactor(node) > 1;
    }

    private boolean isRightHeavy(AVLNode node) {
        return balanceFactor(node) < -1;
    }

    private int balanceFactor(AVLNode node) {
        return (node == null) ? 0 : height(node.leftChild) - height(node.rightChild);
    }

    private int height(AVLNode node) {
        return (node == null) ? -1 : node.height;
    }
}












