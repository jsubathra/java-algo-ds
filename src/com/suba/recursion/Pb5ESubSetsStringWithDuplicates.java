package com.suba.recursion;
import java.util.ArrayList;
import java.util.List;


public class Pb5ESubSetsStringWithDuplicates {

    public static List<String> get_distinct_subsets(String str) {
        List<String> result = new ArrayList<>();
        get_distinct_subsets_Helper(str,0,result);


        return result;
    }

    public static void get_distinct_subsets_Helper(String str, int i, List<String> result){
        if(i == str.length()){
            return;


        }

    }



    public static void main(String[] args){
        String str = "aab";
        get_distinct_subsets(str);

    }

}
