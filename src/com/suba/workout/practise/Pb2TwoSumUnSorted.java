package com.suba.workout.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
// UNSORTED == > HASHING ALG == TC = O(N) and SP = O(1)
// loop through the array
// current = arr[i] and required = target - current
// If required is there in Hashtable means that is the pair and
// so get the indexes ( i and arr.get(required) and return result
// otherwise add in HT the current and i



public class Pb2TwoSumUnSorted {
    public static List<Integer> two_sum(List<Integer> numbers, int target) {
        List<Integer> result= new ArrayList<Integer>();
        HashMap<Integer,Integer> matchSum = new HashMap<>();

        for(int i = 0; i <= numbers.size() -1 ; i++){
            int required = target - numbers.get(i);
            if(matchSum.containsKey(required)){
                result.add(matchSum.get(required));
                result.add(i);
                return result;
            }
            matchSum.put(numbers.get(i), i);
        }
        if(result.size() == 0){
            result.add(-1);
            result.add(-1);

        }
        return result;
    }
    public static void main(String[] args){
        List<Integer> numbers= new ArrayList<Integer>(Arrays.asList(5, 3, 10, 45, 1));
        System.out.println(two_sum(numbers,6));


    }
}
