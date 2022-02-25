package com.suba.workout.practise;

import java.util.*;

// Given SORTED ARRAY return indices that makes the target
// Sorted Array so have to use 2PTR APPROACH ==> TC = O(N) and SC = O(1)
//LOGIC
//LP at start and RP at end
// Chk if sum = num[LP] + num[RP] == target ==> return indices
// sum > target that means that the right side value shd be lower so RP --
// sum < target then LP shd move up to get a higher value
// ALl this shd be done untill LP < RP

public class Pb1TwoSumSorted {
    public static List<Integer> pair_sum_sorted_array(List<Integer> numbers, int target) {
        List<Integer> result= new ArrayList<Integer>();
        int leftPtr = 0;
        int rightPtr = numbers.size() - 1;
        while(leftPtr < rightPtr) {
            int sum = numbers.get(leftPtr) + numbers.get(rightPtr);
            if (sum == target) {
                result.add(leftPtr);
                result.add(rightPtr);
                return result;
            } else if (sum > target) {
                rightPtr--;
            } else {
                leftPtr++;
            }
        }
        if(result.size() == 0){
            result.add(-1);
            result.add(-1);
        }
        return result;
    }
    public static void main(String[] args){
        List<Integer> numbers= new ArrayList<Integer>(Arrays.asList(1, 2, 3, 5, 10));
        System.out.println(pair_sum_sorted_array(numbers,20));


    }
}

