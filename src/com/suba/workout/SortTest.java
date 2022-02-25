package com.suba.workout;

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        var sorter = new Sorting();
        int[] numbers = {80, 53, 11, 40, 90, 55, 10, 50, 60, 20, 52, 100, 30, 70, 55}; //
        //sorter.selectionSortMax(numbers);
        //sorter.bubbleSort(numbers);
        //sorter.insertionSortWithRecursionBubbleUp(numbers,numbers.length);
        // sorter.insertionSortWithRecursionRightShift(numbers,numbers.length);
        //sorter.selectionSortWithIteration(numbers);
        //sorter.mergeSort(numbers);
        sorter.quickSort(numbers);

        System.out.println(Arrays.toString(numbers));
    }
}
