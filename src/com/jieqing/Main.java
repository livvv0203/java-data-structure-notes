package com.jieqing;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.addLast(20);
        list.addLast(30);
        list.addFirst(10);

        int[] array = list.toArray();
        System.out.println(Arrays.toString(array));

    }
}









