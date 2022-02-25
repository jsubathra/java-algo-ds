package com.suba.ds3;

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        //BubbleSort sorter = new BubbleSort();
        //SelectionSort sorter = new SelectionSort();
        //InsertionSort sorter = new InsertionSort();
        //MergeSort sorter = new MergeSort();
       // var sorter = new QuickSort();
        var sorter = new CountingSort();

        int[] numbers = {3, 1, 4, 7, 4, 6, 8};
        sorter.sort(numbers, 8);
        System.out.println(Arrays.toString(numbers));
    }
}
