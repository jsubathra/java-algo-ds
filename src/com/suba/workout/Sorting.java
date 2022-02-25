package com.suba.workout;

import java.util.Arrays;
import java.util.Random;

public class Sorting {
    public void selectionSort(int[] array) {
        // select minvalue and put in correct position
        for (var i = 0; i < array.length; i++) { //3,5,6,2 -> 2,5,6,3 -> 2,3,6,5 -> 2,3,5,6
            var minIndex = i;
            for (var j = i; j < array.length; j++) {
                if (array[j] < array[minIndex])
                    minIndex = j;
            }
            swap(array, minIndex, i);
        }
    }

    public void selectionSortMax(int[] array) {
        // select maxvalue and put in correct position
        for (var i = array.length - 1; i > 0; i--) { //3,5,6,2 -> 2,5,6,3 -> 2,3,6,5 -> 2,3,5,6
            var maxIndex = i;
            for (var j = i; j >= 0; j--) {
                if (array[j] > array[maxIndex])
                    maxIndex = j;
            }
            swap(array, i, maxIndex);
        }
    }

    public void bubbleSort(int[] array) {
        //repeated swaps with adjacent elmts
        for (var i = 0; i < array.length; i++) {
            for (var j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1])
                    swap(array, j, j - 1);
            }

        }
    }

    public void insertionSortWithRecursionBubbleUp(int[] array, int n) {
        if (n <= 1)
            return;
        // break bigger pbm to smaller from n to n-1 = top down
        insertionSortWithRecursionBubbleUp(array, n - 1);
        var lastIndex = n - 1;
        var j = n - 2;
        while (j >= 0 && array[j] > array[j + 1]) {
            swap(array, j + 1, j);
            j = j - 1;
        }
    }

    public void insertionSortWithRecursionRightShift(int[] array, int n) {
        // this is better than multiple swaps before
        if (n <= 1)
            return;
        insertionSortWithRecursionRightShift(array, n - 1);
        var last = array[n - 1];
        var j = n - 2;
        while (j >= 0 && array[j] > last) {
            array[j + 1] = array[j]; // right shifting the items till if last elmt is smaller than previous
            j = j - 1;
        }
        array[j + 1] = last;
    }

    public void selectionSortWithIteration(int[] array) {
        if (array.length <= 1)
            return;
        for (var i = 2; i < array.length; i++) {
            var ith = array[i];
            var j = i - 1;
            while (j >= 0 && array[j] > ith) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = ith;

        }
    }

    public void mergeSort(int array[]) {
        mergeSortHelper(array, 0, array.length - 1);
    }

    private void mergeSortHelper(int array[], int start, int end) {
        if (start >= end)
            return;

        var middleIndex = start + (end - start) / 2;
//        System.out.println("Mid Index: " + middleIndex);

        mergeSortHelper(array, start, middleIndex);
        mergeSortHelper(array, middleIndex + 1, end);

        var i = start; // head of first subarray
        var j = middleIndex + 1; // head of the 2nd subarray
        var k = 0;
        var aux = new int[end - start + 1];
//        System.out.println("Array in this iteration -> " + Arrays.toString(array));
//        System.out.println("Start Index -> " + start);
//        System.out.println("Mid Index -> " + middleIndex);
//        System.out.println("End Index -> " + end);
//        System.out.println("Aux Length -> " + aux.length);
//        System.out.println("Left -> "+Arrays.toString(array));
        while (i <= middleIndex && j <= end) {
//            System.out.println(i + " i -> " + array[i] + "; " + j + " j-> " + array[j]);
            if (array[i] <= array[j]) {
//                System.out.println("setting i");
                aux[k++] = array[i++];
            } else {
//                System.out.println("setting j");
                aux[k++] = array[j++];
            }
        }
        while (i <= middleIndex)
            aux[k++] = array[i++];
        while (j <= end)
            aux[k++] = array[j++];

//        System.out.println("Aux array " + Arrays.toString(aux));
        for (var l = start; l <= end; l++) {
            array[l] = aux[l - start];
        }
//        System.out.println("Org array " + Arrays.toString(array));
    }

    public void swap(int[] array, int index1, int index2) {
        var temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public void quickSort(int array[]) {
       // quickSortHelperLomutos(array, 0, array.length - 1);
        quickSortHelperHoare(array, 0, array.length - 1);

    }

    private void quickSortHelperLomutos(int[] array, int start, int end) {
        if (start >= end)
            return;

        var randomIndex = Math.floor(Math.random()*(end-start+1) + start);

        swap(array,start,(int)randomIndex);
        var pivot = array[start];


        int smaller = start;
        int bigger = start;

        for (bigger = start + 1; bigger <= end; bigger++) { //20, 40, 10, 60, 50 -> 20, 10, 40, 60, 50
            if (array[bigger] < pivot) {
                smaller++;
                swap(array, smaller, bigger);
            }
        }
        swap(array, start, smaller);

        quickSortHelperLomutos(array, start, smaller - 1);
        quickSortHelperLomutos(array, smaller + 1, end);
    }

    private void quickSortHelperHoare(int[] array, int start, int end) {
            if (start >= end)
                return;
            int partitionIndex = getPartitionIndex(array,start,end);
            if (start < end) {
                quickSortHelperHoare(array, start, partitionIndex);
                quickSortHelperHoare(array, partitionIndex + 1, end);
            }
        }

        private int getPartitionIndex (int[] array, int start, int end){
            var pivot = array[start];
            int smaller = start - 1 ;
            int bigger = end + 1;
            while(true) {
                do
                    smaller++;
                while (array[smaller] < pivot);
                do
                    bigger--;
                while (array[bigger] > pivot);

                if (smaller >= bigger)
                    return bigger;

                swap(array, smaller, bigger);
            }
        }
    }
