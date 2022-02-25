package com.suba.recursion;

import java.util.ArrayList;
import java.util.List;


public class Pb5BSubSetsInteger {

    public static List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        subsetsHelper(nums, 0 , new ArrayList<Integer>(), result);
        return result;
    }

    public static void subsetsHelper(int[] nums, int i , ArrayList<Integer> slate,  List<List<Integer>> result){

        result.add(new ArrayList<Integer>(slate));
        for(int pick=i; pick < nums.length; pick++){
            slate.add(nums[pick]);
            subsetsHelper(nums, pick+1, slate, result);
            slate.remove(slate.size() -1);
        }

    }

    public static void main(String[] args){
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }
}
