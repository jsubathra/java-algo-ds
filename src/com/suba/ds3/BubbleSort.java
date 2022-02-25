package com.suba.ds3;

public class BubbleSort {

    //Bubble up the greater number to the correct position
    //Best case when already sorted Passes - o(1) and comparisons o(n)
    // Worse case Passes O(n) and comparisons O(n)
    //Total O(n) for best and O(n^2) for worse so total O(n^2)
    public void sort(int[] items){
        //WOrse are we need to look all the eltms
        for(var i=0; i < items.length; i++){
            for(var j = 1; j < items.length; j++){
                if(items[j] < items[j - 1]){
                    swap(items, j,j -1);
                }
            }
        }
    }

    private void swap(int[] array , int index1, int index2){
        var temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
