package com.suba.javaeg;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharFinder {

    public char findFirstNonReOccurance(String str){
        // a green apple
        Map<Character,Integer> map = new HashMap<>();
        var chars = str.toCharArray();
        for(var ch : chars){
            var count = map.containsKey(ch) ? map.get(ch) : 0; // if ch is there then count will be the number else 0
            map.put(ch, count+1);
        }
        // loop and get ch if count is 1
        for (var ch: chars){
            if(map.get(ch) == 1)
                return ch;
        }
        return Character.MIN_VALUE; // if all strings are repeated
    }

    public void removeDuplicateSets(){
        Set<Integer> set = new HashSet<>();
        int[] numbers = {1, 2, 3, 3, 4, 5, 4, 6, 1};
        for ( var num : numbers){
            set.add(num);
        }
        System.out.println(set);
    }

    public char findFirstReOccurance(String str){
        var chars = str.toCharArray();
        Set<Character> set = new HashSet<>();
        for( var ch : chars){
            if(set.contains(ch))
                return ch;
            set.add(ch);
        }

        return Character.MIN_VALUE;
    }
}
