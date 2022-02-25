package com.suba.ds2;

public class Heap {
    private int items[];
    private int size;


    public Heap(int capacity) {
        items = new int[capacity];
    }

    public void insert(int value){
        if(isFull())
            throw new IllegalStateException();
        //left = (parent * 2) + 1
        //right = (parent *2 ) + 2
        // parent = (index -1 ) /2
        items[size++] = value;
        bubbleUp();

    }

    public boolean isFull(){
        return size == items.length;
    }

    private void bubbleUp(){
        var index = size - 1;
        while(index > 0 && items[index] > items[parent(index)] ){
            swap(index,parent(index));
            index = parent(index);
        }
    }

    private int parent(int index){
        return  (index - 1) /2;
    }

    private void swap(int first, int second){
        var temp = items[first];
        items[first] = items[second];
        items[second] = temp;

    }
}
