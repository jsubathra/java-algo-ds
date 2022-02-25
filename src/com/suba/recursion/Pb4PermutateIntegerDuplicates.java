package com.suba.recursion;
import java.util.*;

public class Pb4PermutateIntegerDuplicates {

    static List<List<Integer>> get_permutations(List<Integer> arr) {
        //Overall call - Do global sort on inut and pass to helper
        //Instead of include and exclude we are doing include and exclude the number of choice
        List<List<Integer>> result = new ArrayList<>();
       // Collections.sort(arr);
        get_permutationsHelper(arr,0,result);
        return result;
    }

    public static void get_permutationsHelper(List<Integer> arr, int i, List<List<Integer>>result){
        //Base Case
        if(i == arr.size()) {
            result.add(new ArrayList<>(arr));
            return;
        }
        //Recursive Case
//        for(int pick = i; pick < arr.size(); pick++){
//            if(pick > i && arr.get(pick) == arr.get(pick - 1)) continue;
//            if (pick != i && arr.get(pick) == arr.get(i)) continue;
//            swap(arr, pick, i);
//            get_permutationsHelper(arr, i + 1, result);
//            swap(arr, pick, i);
//        }

        HashSet<Integer> cntChoice = new HashSet<Integer>();
        for(int pick = i; pick < arr.size(); pick++) {
            if(cntChoice.contains(arr.get(pick)))
                continue;
            cntChoice.add(arr.get(pick));
            swap(arr,pick,i);
            get_permutationsHelper(arr,i+1,result);
            swap(arr,pick,i);


        }


    }


    static void swap(List<Integer> arr, int index1, int index2){
        var temp = arr.get(index1);
        arr.set(index1, arr.get(index2));
        arr.set(index2, temp);
    }




    public static void main(String[] args){
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(2);
        System.out.println(get_permutations(arr));


        }

}
