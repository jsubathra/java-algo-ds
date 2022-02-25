package com.suba.javaeg;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ReverseString {

    private final List<Character> leftArray = Arrays.asList('(','<','[','{');
    private final List<Character> rightArray = Arrays.asList(')','>',']','}');

    public String reverser(String Str){
        if( Str == null)
            throw new IllegalArgumentException();
        Stack<Character> stack = new Stack<>();
       /* for (int i=0; i <= Str.length(); i++){
            stack.push(Str.charAt(i));
        }*/
        for (char ch: Str.toCharArray()) {
            stack.push(ch);
        }

        StringBuffer reverse = new StringBuffer(); // String are immuatab;e and cannot be modified

        while(!stack.isEmpty()){
            reverse.append(stack.pop());
        }
       return reverse.toString();
    }

    public boolean isBalanced(String str){
        Stack<Character> stack = new Stack<>();
        for( char ch : str.toCharArray()){

            if(isLeftBrackets(ch)) // if you find ( push in stack
                stack.push(ch);

            if(isRightBrackets(ch)) { // if you see ) then means matching so pop from stack
                if(stack.empty()) return false; //") 1+2(" // if closing found with no matching start return

                var top =stack.pop();  // if already stack has ( and you see right as ) then matching so pop frpm stack
                if(! isBracketsMatch(top,ch)) return false; // check with index
            }
        }
        return stack.empty();
    }

    private boolean isLeftBrackets(char ch){
        return  leftArray.contains(ch);
    }
    private boolean isRightBrackets(char ch){
        return  rightArray.contains(ch);
    }
    private boolean isBracketsMatch(char left, char right){
       return leftArray.indexOf(left) == rightArray.indexOf(right);
    }

}
