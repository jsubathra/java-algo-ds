package com.suba.recursion;
import java.util.ArrayList;
import java.util.List;


public class Pb5DSubSetsString {

    public static List<String> get_distinct_subsets(String str) {
        List<String> result = new ArrayList<String>();
        StringBuilder stringBuilder = new StringBuilder();
        get_distinct_subsets_Helper(str,0,stringBuilder,result);


        return result;
    }

    public static void get_distinct_subsets_Helper(String str, int i, StringBuilder slate, List<String> result){

       // result.add();

//        for(int pick = i; pick < str.length(); pick++){
//            stringBuilder.append(str.charAt(pick));
//            get_distinct_subsets_Helper(str,i+1,stringBuilder,result);
//            stringBuilder.deleteCharAt(str.length());
//
//        }

    }



    public static void main(String[] args){
        String str = "abc";
        System.out.println(get_distinct_subsets(str));

    }

}
