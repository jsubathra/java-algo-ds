package com.suba.recursion;

import java.util.*;

public class Pb5CSubSetsIntegerDuplicates {

    public static List<List<Integer>> subsetsDuplicate(int[] nums){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        subsetsDuplicateHelper(nums,0,new ArrayList<Integer>(), result);
        return result;
    }

    public static void subsetsDuplicateHelper(int[] nums,int i,ArrayList<Integer> slate,List<List<Integer>> result){
        // To Add empty list
        result.add(new ArrayList<Integer>(slate));

        for(int pick =i; pick < nums.length; pick++){
           if(pick > i && nums[pick] == nums[pick-1] ) continue;
           slate.add(nums[pick]);
           subsetsDuplicateHelper(nums,pick+1,slate,result);
           slate.remove(slate.size()-1);
        }


    }

    public static void main(String[] args){
        int[] nums = {1,2,2};
        System.out.println(subsetsDuplicate(nums));
    }
}
