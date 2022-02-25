package com.suba.workout.classproblems;

import java.util.Arrays;

public class GroupNumbers {
    static int[] solve(int[] arr) {
        int a =0;
        int b = arr.length -1;
        while(a < b) {
            if (arr[a] % 2 == 1 ){
                swap(arr,a,b);
                b--;
            }else
                a++;
        }
        return arr;
    }
    static int[] solveUsingLomutos(int[] arr) {
        int a =0;
        int b = -1;
        while(a <= arr.length - 1) {
            if(arr[a] % 2 == 0){
                b++;
                if(b != a)
                    swap(arr,a,b);
            }
            a++;
        }
        return arr;
    }

    private static void swap(int[] array, int index1, int index2) {
        var temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args){
        int[] arr = new int[] {2,4,5,6};
        System.out.println(Arrays.toString(solveUsingLomutos(arr)));
    }


}
