package com.suba.workout.classproblems;

import java.util.*;

public class KthFreq {


    public static ArrayList<Integer> find_top_k_frequent_elements(ArrayList<Integer> arr, Integer k) {
        ArrayList<Integer> result = new ArrayList<>();

        int maxFreq = 1;
        //Sort - in place Sort
        Collections.sort(arr);

        // System.out.println(arr);

        var freqMap = new HashMap<Integer, ArrayList<Integer>>();
        int count = 1;
        var previous = arr.get(0);
        for (int i = 1; i <= arr.size() - 1; i++) {
            if (Objects.equals(arr.get(i), previous)) {
                count++;
            } else {
                addToFreqMap(freqMap, count, previous);
                System.out.println("Set Maxvalue " + maxFreq);
                maxFreq = Math.max(maxFreq, count);
                count = 1;
            }
            previous = arr.get(i);
        }

        addToFreqMap(freqMap, count, arr.get(arr.size() - 1));
        maxFreq = Math.max(maxFreq, count);

        for (Integer q : freqMap.keySet()) {
            System.out.println("Key " + q + " Value " + freqMap.get(q));
        }
        System.out.println("Max Freq " + maxFreq);

        int cnt = 0;

        while (cnt < k && maxFreq > 0) {
            ArrayList<Integer> freqMapArr = freqMap.get(maxFreq) != null ? freqMap.get(maxFreq) : new ArrayList();
            for (var q = 0; q <= freqMapArr.size() - 1; q++) {
                if (cnt >= k) {
                    break;
                }
                result.add(freqMapArr.get(q));
                cnt++;
                //System.out.println("Count -> " + cnt);
            }
            maxFreq--;
        }

        return result;
    }

    private static void addToFreqMap(HashMap<Integer, ArrayList<Integer>> freqMap, int count, int value) {
        if (freqMap.get(count) != null) {
            freqMap.get(count).add(value);
        } else {
            var a = new ArrayList<Integer>();
            a.add(value);
            freqMap.put(count, a);
        }
    }

    public static void main(String[] args) {
        //Input: [1, 2, 3, 2, 4, 3, 1], 2


        ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList(5, 7, 7, 7, 7, 7));
        System.out.println(find_top_k_frequent_elements(numbers, 1));
    }

}
