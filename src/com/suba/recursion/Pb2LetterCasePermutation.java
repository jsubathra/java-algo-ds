package com.suba.recursion;
import java.util.List;
import java.util.ArrayList;

public class Pb2LetterCasePermutation {


    public static void main(String[] args){

        String input = "a1b2";
        System.out.println(letter_case_permutations(input));

    }
    public static List<String> result = new ArrayList<>();

    public static List<String> letter_case_permutations(String str) {
        char[] partialSoln = new char[str.length()];
        letter_case_permutations_Helper(str,0,partialSoln);
        return result;

    }
    public static void letter_case_permutations_Helper(String str,int i, char[] partialSoln) {
        //Base Condition
        if(i == str.length()){
            result.add(new String(partialSoln));
            return;
        }else{
            char ch = str.charAt(i);
            if(Character.isDigit(ch)){
                partialSoln[i]=ch;
                letter_case_permutations_Helper(str,i+1,partialSoln);
            }else{
                partialSoln[i] = Character.toUpperCase(ch);
                letter_case_permutations_Helper(str,i+1,partialSoln);
                partialSoln[i] = Character.toLowerCase(ch);
                letter_case_permutations_Helper(str,i+1,partialSoln);

            }

        }

    }
    }


