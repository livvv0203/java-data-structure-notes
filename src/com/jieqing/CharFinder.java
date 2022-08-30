package com.jieqing;

import java.util.HashMap;
import java.util.Map;

public class CharFinder {

    // String s = "A Green Apple";
    // Find First Non-repeating Character
    public char findFirstNonRepeatingChar(String str) {

        Map<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();

        for (char ch : chars) {
            int count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, count + 1);
        }

        // Iterate the string
        for (char ch : chars) {
            if (map.get(ch) == 1)
                return ch;
        }
        return Character.MIN_VALUE;
    }
}
