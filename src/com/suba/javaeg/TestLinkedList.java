package com.suba.javaeg;

import java.util.Arrays;

public class TestLinkedList {
    public static void main(String[] args) {
        /*LinkedList list = new LinkedList();
        list.addFirst(3);
        list.addLast(5);
        list.addLast(7);
        list.addLast(9);
        list.addLast(11);
        list.addLast(13);


//        list.removeFirst();
//        list.removeLast();
        list.revereLL();
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list.getKthNodeFromEnd(2));
        System.out.println(list.getMiddleNodeValue());
*/

    ReverseString rvr = new ReverseString();

    System.out.println("Reverse " + rvr.reverser("Subathra"));
    var result= rvr.isBalanced("((1+2]]");
        System.out.println(result);
    }
}
