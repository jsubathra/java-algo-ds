package com.suba.ds3;

public class SelectionSort {

    //Select the next min value and move to current position
    //Best case when already sorted Passes - o(n) and comparisons o(n)
    // Worse case Passes O(n) and comparisions O(n)
    //Total Best and  worse so total O(n^2)

    public void sort(int[] array){
        for( var i =0; i < array.length ; i++){
            //find min value and swap its index with the current position
            var minIndex =findMinIndex(array,i);
            swap(array,minIndex,i);

        }
    }

    private int findMinIndex(int[] array,int index){
        // we have to look in the unsorted only to find the next min
        var minIndex=index;
        for(var j =index; j < array.length; j++){
            if(array[j] < array[minIndex]){
                minIndex = j;
            }
        }
        return minIndex;
    }

    private void swap(int[] array , int index1, int index2){
        var temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
