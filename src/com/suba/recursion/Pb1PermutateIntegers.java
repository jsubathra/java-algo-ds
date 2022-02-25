package com.suba.recursion;
import java.util.ArrayList;
import java.util.List;
public class Pb1PermutateIntegers {

    static List<List<Integer>> get_permutations(List<Integer> arr) {
        List<List<Integer>> result = new ArrayList<>();
        get_permutationsBTHelper(arr,0,result);
        return result;
    }

    public static void get_permutationsBTHelper(List<Integer> arr, int i,List<List<Integer>> result) {
            //Base Case
            if(i == arr.size()) {
                result.add(new ArrayList<>(arr));
                return;
            }

            //Recursive Case
            for(int pick = i; pick < arr.size(); pick++){
                swap(arr, i , pick);
                get_permutationsBTHelper(arr, i+1, result);
                swap(arr, i , pick);

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
            arr.add(3);
            System.out.println(get_permutations(arr));



    }
}
