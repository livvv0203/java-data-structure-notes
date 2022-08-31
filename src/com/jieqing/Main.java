package com.jieqing;

public class Main {

    public static void main(String[] args) {

        Tree tree = new Tree();
        tree.insert(2);
        tree.insert(3);
        tree.insert(5);
        tree.insert(7);

        Tree tree2 = new Tree();
        tree2.insert(2);
        tree2.insert(3);
        tree2.insert(5);
        tree2.insert(7);

        boolean res = tree.equals(tree2);
        System.out.println(res);

    }
}












