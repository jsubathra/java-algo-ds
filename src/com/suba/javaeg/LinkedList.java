package com.suba.javaeg;


import java.util.NoSuchElementException;
import java.lang.IllegalArgumentException;


public class LinkedList<K> {
    private Node first;
    private Node last;
    private int size;

    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public void addLast(int item) {
        var node = new Node(item);
        if (first == null) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public void addFirst(int item) {
        var node = new Node(item);
        if (first == null) {
            first = last = node;
        } else {
            node.next = first;
            first = node;
        }
        size++;
    }

    public int indexOf(int item) {
        if (first == null) return -1;
        var current = first;
        int index = 0;
        while (current != null) {
            if (current.data == item) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    public void removeFirst() {
        if (first == null)
            throw new NoSuchElementException();
        if (first == last) {
            first = last = null;
            return;
        }
        var second = first.next;
        first.next = null;
        first = second;
        size--;
    }

    public int size() {
        return size;
    }

    public void removeLast() {
        if (first == null)
            throw new NoSuchElementException();
        if (first == last) {
            first = last = null;
            size = 0;
            return;
        }
        var current = first;
        while (current.next == last) {
            current.next = null;
            last = current;
        }
        size--;
    }

    public void reverse() {
        var current = first; //3
        var previous = first; //3

        while (current != null) { // [3,5,7,9
            var next = current.next; //[5,7,9,null
            if (current == first) {//[3
                current.next = null;
                last = current;
            } else {
                current.next = previous;//[3,5,7
            }
            previous = current; //[3,5,7,9
            current = next; //[5,7,9,null
        }
        first = previous;
    }

    public void revereLL() {
        // 10 ->20 ->30
        if( first == null) return;
        var previous = first;
        var current = first.next;
        if(previous == current) return; // if list empty then
        while (current != null) {
            var next = current.next;
            current.next = previous; // reverse direction of li
            previous = current;
            current = next;
        }
        last = first; // make 10 as last
        last.next = null; // make 10 refer to null
        first = previous; // make 30 as first

    }

    public int[] toArray(){
        var array = new int[size];
        var current = first;
        var index = 0;
        while(current != null){
            array[index++] = current.data;
            current = current.next;
        }
        return array;
    }

    public int getKthNodeFromEnd(int k) {
        // if list empty
        if(first == null ) throw new IllegalStateException();
        // Add 2 pointers such that k-1 apart
        // 10 -> 20 -> 30 -> 40 ->50
        // a      b
       var a = first;
       var b = first;
       //Move the 2nd pointer by k-1
       for ( int i = 0; i < k-1; i++) {
           b = b.next;
           //if k invalid then throw exception
           if(b == null) throw  new IllegalArgumentException();
       }
       // Move untill second pointer points to end
       while ( b != last){
           a = a.next;
           b = b.next;
       }
       // return a.value
       return a.data;

    }

    public int getMiddleNodeValue(){
        // if even no: of elements middle will be 2 nodes
        // 10 -> 20 -> 30 -> 40 ->50
        // Floyds cycle finding Algorithm - use 2 pointers slow and fast - > move fast by 2 steps and slow by one step
        // and at one point the fast meets the slow in a loop
        var a = first;
        var b = first;
        while ( b != last && b .next != last){
            a = a.next;
            b = b.next.next;
        }
        if( b == last) //this means odd number of items
            return a.data;
        else
            return a.data + a.next.data; // either add two or return with string

    }
}
