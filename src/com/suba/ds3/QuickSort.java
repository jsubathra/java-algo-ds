package com.suba.ds3;

public class QuickSort {

    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private void sort(int[] array, int start, int end) {
        //Base Condition -- need to return with
        if (start >= end)
            return;
        //Partition
        var boundary = partition(array, start, end);
        // Sort left -- from 0 to pivot's index-1
        sort(array, start, boundary - 1);
        // Sort Right partition -- from  pivot's index+1 to end
        sort(array, boundary + 1, end);
    }

    private int partition(int[] array, int start, int end) { //0, 1
        //var pivot = array[array.length - 1];
        var pivot = array[end];

        //var boundary = -1; // which means left partition is empty
        var boundary = start - 1; // which means left partition is empty (0-1) = -1

        //for (var i =0 ; i < array.length; i++ ){
        for (var i = start; i <= end; i++) {
            if (array[i] <= pivot) {
                //swap(array,i,++boundary);
                boundary++; // if item is less than pivot then we need to increase the boundary to form the left partition
                swap(array, i, boundary); // swap item with the item in the boundary
            }
        }
        return boundary; // index of the pivot after the move.
    }

    private void swap(int[] array, int index1, int index2) {
        var temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

}
