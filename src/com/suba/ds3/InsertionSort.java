package com.suba.ds3;

public class InsertionSort {

    // assue first elmt in correct position
    // check if next item is correct -- if not shift copy the item to current and shift first item to right

    public void sort(int[] array){
        // we assume 1st item is in correct position so start loop for 2nd item so i starts at 1
        for(var i =1; i < array.length; i++){
            var current = array[i];
            // we have to chk current with previous item so j is i-1
            var j = i-1;
            // if arr[0] 8 > arr[1] 2 we copy arr[0] 8  to arr[1] 2 and then
            while( j >=0  && array[j] > current){
                array[ j+1 ] = array[j];
                j--;
            }
            // copy current 2 to arr[0]
            array[j+1] = current;
        }

    }
}
