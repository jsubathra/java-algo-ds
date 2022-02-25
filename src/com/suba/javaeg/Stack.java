package com.suba.javaeg;

import java.util.Arrays;

public class Stack {

    private int[] stackArray = new int[5];
    private int count =0;
    private int size = 0;

    public Stack(int size){
        this.size = size;
    }

    public void push(int item){
        if(count == stackArray.length)
            throw new StackOverflowError();
        stackArray[count++] = item;
    }
    // remove the last item of the stack
    public int pop(){
        if(count == 0)
            throw  new IllegalStateException();
        return stackArray[--count]; // decrement count and return the last pushed item and also remove it

    }
    // give the last item but not remove it
    public int peek(){
        if(count == 0)
            throw  new IllegalStateException();
        return stackArray[count -1]; // decrement count and return the last pushed item

    }
    public boolean isEmpty(){
        return count == 0 ;
    }

@Override
public String toString(){
        var content = Arrays.copyOfRange(stackArray,0,count) ;
        return Arrays.toString(content);

    }
}
