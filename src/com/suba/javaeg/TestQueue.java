package com.suba.javaeg;

public class TestQueue {
    public static void main(String[] args){
        ArrayQueue queue = new ArrayQueue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.dequeue();
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(70);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(80);
        queue.enqueue(90);
        System.out.println(queue.toString());
        System.out.println(queue.peek());

    }
}
