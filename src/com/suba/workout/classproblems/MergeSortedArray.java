package com.suba.workout.classproblems;

import java.util.Arrays;

public class MergeSortedArray {
//    static void merger_first_into_second(int[] arr1, int[] arr2) {
//        for (var i = 0; i < arr1.length; i++) {
//            for (var j = 1; j < arr2.length; j++) {
//                if (arr2[j - 1] > arr1[i]) {
//                    var k = j - 1;
//                    var temp1 = arr2[k];
//                    var temp2 = 0;
//                    while (k < arr2.length - 1) {
//                        temp2 = arr2[k + 1];
//                        arr2[k + 1] = temp1;
//                        temp1 = temp2;
//                        k++;
//                    }
//                    arr2[j - 1] = arr1[i];
//                    break;
//                }
//            }
//        }
//    }

     static void merger_first_into_second(int[] arr1, int[] arr2) {
         int a1Ptr = arr1.length - 1;
         int a2Ptr = arr1.length - 1;
         int endIndex = arr2.length - 1;

         while(endIndex >= 0) {
             if(a1Ptr < 0){
                 arr2[endIndex] = arr2[a2Ptr--];
             }else if (a2Ptr < 0 ){
                 arr2[endIndex] = arr1[a1Ptr--];
             } else {
                 if (arr1[a1Ptr] < arr2[a2Ptr]) {
                     arr2[endIndex] = arr2[a2Ptr];
                     a2Ptr--;
                 } else {
                     arr2[endIndex] = arr1[a1Ptr];
                     a1Ptr--;
                 }
             }
             endIndex--;
         }
      }


    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 3, 5};
        int[] arr2 = new int[]{2, 4, 6, 0, 0, 0};

        merger_first_into_second(arr1, arr2);
    }

//    int i = arr1.length - 1;
//    int j = arr1.length - 1;
//    int endIndex = arr2.length - 1;
//        while (endIndex >= 0 && i >= 0 && j >= 0) {
//        System.out.println("Endindex " + endIndex + " i " + i + " j " + j);
//        if (arr1[i] <= arr2[j]) {
//            arr2[endIndex] = arr2[j];
//            endIndex--;
//            j--;
//        } else {
//            arr2[endIndex] = arr1[i];
//            endIndex--;
//            i--;
//        }
//    }
//        System.out.println("At the end of Endindex " + endIndex + " i " + i + " j " + j);
//        System.out.println(Arrays.toString(arr2));
}
