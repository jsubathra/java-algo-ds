package com.suba.ds3;

public class MergeSort {
    public void sort(int[] array) {

        // Base Condition == if array has single item or no item
        if(array.length <= 1 )
            return;

        // Divide this array into half
        var middleIndex = array.length / 2;
        // create left sublist
        int[] left = new int[middleIndex];
        for (var i = 0; i < middleIndex; i++)
            left[i] = array[i];

        // create right sublist from middleindex to end 5/2 - 3 items in right
        int[] right = new int[array.length - middleIndex];
        for (var i = middleIndex; i < array.length; i++)
            right[i - middleIndex] = array[i];

        //Sort each half recursively
        sort(left);
        sort(right);

        //Merge
        merge(left,right,array);

    }

    private void merge(int[] left, int[] right, int[] result) {

        int i=0, j=0, k =0; // if or left,j for right and k for result
        // do below when both left and right -- left and right may not be same length
        while( i < left.length && j < right.length){
            if(left[i] <= right[j])
                result[k++] = left[i++]; // copy left to result
            else
                result[k++] = right[j++]; // copy right to result if right is smaller

        }
        // if here then cnt of left != right so remaining items copy to result
       while (i < left.length)
            result[k++] = left[i++];

        while (j < right.length)
            result[k++] = right[j++];

    }

}


