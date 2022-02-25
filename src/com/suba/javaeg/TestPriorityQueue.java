package com.suba.javaeg;

public class TestPriorityQueue {
    public static void main(String[] args){
        PriorityQueue pQueue = new PriorityQueue(5);
        pQueue.addItem(5);
        pQueue.addItem(3);
        pQueue.addItem(2);
        System.out.println(pQueue.remove()); // In PQ , the highest number will be removed
        pQueue.addItem(4);

        System.out.println(pQueue);
    }
}
