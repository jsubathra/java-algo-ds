package com.suba.ds3;

public class CountingSort {

    public void sort(int[] array, int max){
        int[] countArr = new int[max + 1];
        for(var item : array){
            countArr[item]++;
        }
        var k = 0;
        for(var i=0; i< countArr.length; i++){
            for(var j=0; j< countArr[i]; j++){ //5th index will have 3 which means  the next 3 elmts will be 5 in i/p array
                array[k++] = i; // put 5 in the next 3 items
            }
        }
    }
}
