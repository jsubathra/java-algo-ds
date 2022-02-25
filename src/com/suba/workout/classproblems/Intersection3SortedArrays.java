package com.suba.workout.classproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersection3SortedArrays {


    public static List<Integer> find_intersection(List<Integer> arr1, List<Integer> arr2, List<Integer> arr3) {
        List<Integer> result = new ArrayList<Integer>();
        int iPtr = 0;
        int jPtr = 0;
        int kPtr = 0;
        while (iPtr < arr1.size() && jPtr < arr2.size() && kPtr < arr3.size()) {
            int iVal= arr1.get(iPtr);
            int jVal= arr2.get(jPtr);
            int kVal= arr3.get(kPtr);
            if((iVal == jVal) && (iVal == kVal)){
                result.add(iVal);
                iPtr++;
                jPtr++;
                kPtr++;
            }else if (iVal <= jVal && iVal <= kVal){
                iPtr++;
            }else if (jVal <= iVal && jVal <= kVal) {
                jPtr++;
            }else if (kVal <= jVal && kVal <= iVal) {
                kPtr++;
            }
        }
        if(result.size()==0) {
            result.add(-1);
        }
        return result;
    }

    public static void main(String[] args){
        var list1 = new ArrayList<Integer>(Arrays.asList(2,5,10));
        var list2 = new ArrayList<Integer>(Arrays.asList(3,4,11));
        var list3 = new ArrayList<Integer>(Arrays.asList(2,4,10));
        System.out.println(find_intersection(list1,list2,list3));


    }
}
