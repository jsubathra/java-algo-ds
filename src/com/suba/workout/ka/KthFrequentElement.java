package com.suba.workout.ka;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class KthFrequentElement {
    static ArrayList<Integer> find_top_k_frequent_elements(ArrayList<Integer> arr, Integer k) {
        ArrayList<Integer> result = new ArrayList<>();
        Collections.sort(arr);
        System.out.println("Input " + Arrays.toString(arr.toArray()));
        var maxCount = 0;
        var count = 1;
        var previous = arr.size() > 0 ? arr.get(0) : 0;
        for (var i = 1; i <= arr.size() - 1; i++) {
            if (arr.get(i).equals(previous)) {
                count++;
            } else {
                if (count >= maxCount) {
                    maxCount = count;
                    count = 1;
                    if (result.size() >= k) {
                        result.remove(0);
                    }
                    result.add(previous);
                }
            }
            previous = arr.get(i);
        }


        return result;
    }

    public static void main(String[] args) {
        var k = 6;
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 5, 4, 6, 5, 8, 3, 6, 4));
//        ArrayList<Integer> arrayList = new ArrayList<>();
        System.out.println("Input " + Arrays.toString(arrayList.toArray()));
        var result = find_top_k_frequent_elements(arrayList, k);
        System.out.println("Final Result " + Arrays.toString(result.toArray()));
    }
}
