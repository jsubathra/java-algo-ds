package com.suba.javaeg;
import java.util.Arrays;
import java.util.LinkedList;

public class HashTable {

    /*//Hashtable
    //put(k,v)
    //get(k)
    //remove(k)
    //k: int
    //v: String
    // collision : through chaining which means linked list
    // kv to be stored not as  int[] or str[] but in a class KVPAIR or Entry(wraps kvpair) because we need to store both
    // linkedlist[] so need not worry the size
    //LinkedList[Entry/KVPair] [LL,LL,LL,LL]*/

    private class KeyValuePair {
        private int key;
        private String value;

        public KeyValuePair(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<KeyValuePair>[] entries = new LinkedList[5];

    public void put(int key, String value){
        // where in the entries[] we have to store so we need the hashcode
        int index = hashCode(key);
        // if no entry create new instance of LL
        if(entries[index] == null)
            entries[index] = new LinkedList<>();

        // to check duplicates
        var bucket = entries[index];
        for(var entry : bucket){
            if(entry.key == key) {
                entry.value = value; // It can have No duplicates , so we replace the value and return
                return;
            }
        }

        // if already entry at that index we need to wrap the kV at the end of the LL
        bucket.addLast(new KeyValuePair(key, value)); // same index but kv added at the end of LL - chaining to avoid collision

    }

    public String get(int key){
        int index = hashCode(key);
        var bucket = entries[index];
        if(bucket != null) {
            for (var entry : bucket) {
                if (entry.key == key)
                    return entry.value;
            }
        }
        return null;
    }

    public void remove(int key){
        int index = hashCode(key);
        var bucket = entries[index];
        // If no elmts in bucket
        if(bucket == null)
            throw new IllegalStateException();
        if(bucket != null) {
            for (var entry : bucket) {
                if (entry.key == key){
                    bucket.remove(entry);
                    return;
                }

            }
            // if key not found
            throw new IllegalStateException();
        }
    }


    private int hashCode(int key){
        return key % entries.length; //(key reduced to size of array)
    }
}
