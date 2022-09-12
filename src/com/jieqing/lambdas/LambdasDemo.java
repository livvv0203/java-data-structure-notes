package com.jieqing.lambdas;

public class LambdasDemo {

    public static void show() {

        // Lambdas
        greet(message -> System.out.printf(message));

//        greet(new Printer() {
//            @Override
//            public void print(String message) {
//                System.out.println(message);
//            }
//        });
    }

    public static void greet(Printer printer) {
        printer.print("Hello");
    }

}
