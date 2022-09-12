package com.jieqing;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

    public static void show() {

        Customer c1 = new Customer("a", "e1");
        Customer c2 = new Customer("b", "e2");

        Map<String, Customer> map = new HashMap<>();
        map.put(c1.getEmail(), c1);
        map.put(c2.getEmail(), c2);

        Customer unknown = new Customer("Unknown", "N/A");
        Customer customer = map.get("e1"); // O(1)
        Customer customer1 = map.getOrDefault("e10", unknown);

        boolean isExist = map.containsKey("e1");

        for (Map.Entry e : map.entrySet()) {
            System.out.println(e.getValue());
        }



    }
}










