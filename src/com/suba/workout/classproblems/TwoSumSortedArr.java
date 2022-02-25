package com.suba.workout.classproblems;

import com.suba.javaeg.HashTable;

import java.util.*;


public class TwoSumSortedArr {
    public static List<Integer> pair_sum_sorted_array(List<Integer> numbers, int target) {
        List<Integer> result = new ArrayList<Integer>();
        int leftPointer = 0;
        int rightPointer = numbers.size() - 1;
        while (leftPointer < rightPointer) {
            int sum = numbers.get(leftPointer) + numbers.get(rightPointer);
            if (sum == target) {
                result.add(leftPointer);
                result.add(rightPointer);
                return result;
            } else if (sum > target)
                rightPointer--;
            else if (sum < target)
                leftPointer++;
        }
        if (result.size() == 0) {
            result.add(-1);
            result.add(-1);
        }
        return result;
    }

    public static List<Integer> two_sum(List<Integer> numbers, int target) {
        List<Integer> result = new ArrayList<Integer>();
        HashMap<Integer, Integer> aux = new HashMap();
        for (int i = 0; i < numbers.size(); i++) {
            int n2 = target - numbers.get(i);
            if (aux.containsKey(n2)) {
                result.add(aux.get(n2)); // only when the match is there
                result.add(i); //
                return result;
            } else {
                aux.put(numbers.get(i), i);
            }

        }
        if (result.size() == 0) {
            result.add(-1);
            result.add(-1);
        }
        return result;

    }


    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<Integer>();

        Collections.addAll(numbers, 5, 3, 10,7, 45, 1);
        // var result = TwoSumSortedArr.pair_sum_sorted_array(numbers, 7);
        var result = TwoSumSortedArr.two_sum(numbers, 14);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
