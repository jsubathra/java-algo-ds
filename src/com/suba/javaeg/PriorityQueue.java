package com.suba.javaeg;

import java.util.Arrays;

public class PriorityQueue {
    // Numbers are inserted in the asc irrespective of the order inserted

    private int[] items;
    private int count;

    public PriorityQueue(int capacity){
        items = new int[capacity];
    }

    public void addItem(int item){
        if(isFull())
            throw new IllegalStateException();
        int i = shiftItemsToInsert(item);
        items[i] = item;
        count++;
    }

    private int shiftItemsToInsert(int item) {
        // loop from end to shift items
        // chk if item to be inserted is larger than the item in last index
        //if so shift else move to next index
        //2
        // [1 ,3, 5 ]
        int i;
        for (i = count - 1; i >= 0; i--){
            if(items[i] > item)
                items[i+1] = items[i];
            else
                break;
        }
        return i +1;
    }

    public int remove(){
        if(isEmpty())
            throw new IllegalStateException();
        return items[--count];
    }

    public boolean isEmpty(){
        return count == 0;
    }

    private boolean isFull() {
       return  count == items.length;
    }
    @Override
    public String toString(){
        return Arrays.toString(items);
    }
}
