package com.suba.javaeg;

import java.util.Arrays;

public class ArrayQueue {

    private int[] items;
    private int front;
    private int rear;
    private int count;

    public ArrayQueue(int capacity){
        items = new int[capacity];

    }

    public void enqueue(int item){
        if(count == items.length) throw new IllegalStateException();
        //items[front++] = 0; // even if array has few space when 5th element added you will get array index error
        // To solve it 5 -0/ 6-1/ 7-2/8-3/9-4/10-0/11-1 ===> so its left % 5 = remainder
        // circular array
        items[rear] = item;
        rear = (rear+1) % items.length;
        count++;
    }

    public int dequeue(){
        //10,20,30
        var item = items[front];
        items[front] =0;
        front = (front + 1) % items.length;
        count--;
        return item;
    }

    public int peek(){
        return items[front];
    }

    @Override
    public String toString(){
        return Arrays.toString(items);
    }
}
