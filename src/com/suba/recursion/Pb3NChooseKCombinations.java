package com.suba.recursion;
import java.util.ArrayList;
import java.util.List;

public class Pb3NChooseKCombinations {
    public static List<List<Integer>> find_combinations(int n, int k) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        find_combinations_Helper(n,k,1,current,result);
        return result;
    }
    public static void find_combinations_Helper(int n, int k,int start, List<Integer> current , List<List<Integer>> result){
        //BackTracking Case
        if(current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
//       for(int j=start; j<=n;j++){
//            current.add(j);
//            find_combinations_Helper(n,k,j+1, current,result);
//            current.remove(current.size()-1);
//
//        }

        //Base Case
        if(start > n) {
            return;
        }

        //Include choice
        current.add(start);
        find_combinations_Helper(n,k,start+1,current,result);
        current.remove(current.size()-1);

        //Exclude choice
        find_combinations_Helper(n,k,start+1,current,result);


    }


    public static void main(String[] args){
        System.out.println(find_combinations(4,2));
    }



}
