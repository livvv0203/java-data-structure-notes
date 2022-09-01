package com.jieqing;

import java.util.ArrayList;
import java.util.List;

public class MapDemo {

    public static void show() {
        List<Customer> customers = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getName() == "John") {
                System.out.println("Found!");
            }
        }
    }
}
