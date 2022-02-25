package com.suba.javaeg;

import java.util.HashMap;

public class HashTableTest {
    public static void main(String[] args){
        /*HashTable table = new HashTable();
        table.put(6,"A"); //1
        table.put(8,"B"); //3
        table.put(11,"C"); // 1
        table.put(6,"A+");
        table.remove(60);
        System.out.println(table.get(6));
*/

        var items = new int[] {1, 2, 2, 3, 3, 3, 3, 4};
        var map = new HashMap<Integer,Integer>();
        for ( var item : items){
                if(map.containsKey(item))
                    map.put(item,map.get(item) +1);
                else
                    map.put(item,1);
        }
        int frequency = 1;
        int key=0;
        for( var findFreq : map.entrySet()){
            var value = findFreq.getValue();
            if(findFreq.getValue() > frequency){
                frequency = findFreq.getValue();
                key = findFreq.getKey();


            }
        }
        System.out.println(frequency);
        System.out.println(key);


    }
}
