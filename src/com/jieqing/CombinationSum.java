package com.jieqing;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        findSum(candidates, result, target, new ArrayList<Integer>(), 0);
        return result;
    }

    private void findSum(int[] numbers, List<List<Integer>> result, int target, List<Integer> temp, int start) {
        // Base Condition of Recursion
        if (target < 0) return;
        if (target == 0) {
            result.add(new ArrayList<>(temp)); // deep copy of temp
            return;
        }

        for (int i = start; i < numbers.length; i++) {
            temp.add(numbers[i]);
            findSum(numbers, result, target - numbers[i], temp, i);
            temp.remove(temp.size() - 1);
        }
    }
}






