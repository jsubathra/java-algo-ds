package com.suba.workout.classproblems;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {
    public static ArrayList<Integer> merge_sort(ArrayList<Integer> arr) {
        merge_sort(arr, 0, arr.size() - 1);
        return arr;
    }

    private static ArrayList<Integer> merge_sort(ArrayList<Integer> arr, int start, int end) {

        if (start >= end) return new ArrayList<Integer>();

        int middleIndex = start + (end - start) / 2;

        int i = start;
        int j = middleIndex + 1;

        merge_sort(arr, start, middleIndex);
        merge_sort(arr, middleIndex + 1, end);

        ArrayList<Integer> aux = new ArrayList<Integer>();
        while (i <= middleIndex && j <= end) {
            if (arr.get(i) <= arr.get(j)) {
                aux.add(arr.get(i));
                i++;
            } else {
                aux.add(arr.get(j));
                j++;
            }
        }
        while (i <= middleIndex) {
            aux.add(arr.get(i));
            i++;
        }
        while (j <= end) {
            aux.add(arr.get(j));
            j++;
        }

        for (var l = start; l <= end; l++) {
            arr.set(l, aux.get(l - start));
//            arr.remove(l);
//            arr.add(l, aux.get(l - start));
        }
        return arr;
    }

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList(5, 8, 3, 9, 4, 1, 7, 6));
        System.out.println(merge_sort(numbers));
    }

}
