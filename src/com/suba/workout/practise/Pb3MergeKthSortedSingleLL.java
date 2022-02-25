package com.suba.workout.practise;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.List;

public class Pb3MergeKthSortedSingleLL {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }
    // Build a heap with Kth elements
    //Pop min to aux
    // move index to the list from where elm was popped till you get Null
    // Push that elm to heap and do heapify
    // repeat till null on all lists
    //TIME COMPLEXITY = O(N log K) - SPACE = O(K)

    public static SinglyLinkedListNode merge_k_lists(List<SinglyLinkedListNode> lists) {
        //If list is null or no  elements
        if (lists == null || lists.size() == 0) {
            return null;
        }

        //If size is 1 return just the same LL
        if (lists.size() == 1) return lists.get(0);

        // Create a minHeap using PQ
        PriorityQueue<SinglyLinkedListNode> minHeap = new PriorityQueue<>(new Comparator<SinglyLinkedListNode>() {
            @Override
            public int compare(SinglyLinkedListNode o1, SinglyLinkedListNode o2) {
                return o1.data - o2.data;
            }
        });

        //Create the result and put dummy value
        SinglyLinkedListNode dummyNode = new SinglyLinkedListNode(-1);
        // Create one for the pointer
        SinglyLinkedListNode currentNode = dummyNode;

        //Loop through the lists and get Kth elements from all the LL's at one time and put in minHeap
        for (int k = 0; k < lists.size(); k++) {
            if (lists.get(k) != null) {
                minHeap.offer(lists.get(k));
            }
        }

        while (!minHeap.isEmpty()) {
            // Loop through the minHeap and pop the root element
            SinglyLinkedListNode popped = minHeap.poll();
            // the element popped from the minheap -- from that LL get the next element and add to minHeap
            if (popped.next != null) {
                minHeap.offer(popped.next);
            }
            // Move the pointer to the next node in that LL
            currentNode.next = popped;
            currentNode = currentNode.next;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {

        SinglyLinkedListNode node_1_3 = new SinglyLinkedListNode(5);
        SinglyLinkedListNode node_1_2 = new SinglyLinkedListNode(3);
        node_1_2.next = node_1_3;
        SinglyLinkedListNode node_1_1 = new SinglyLinkedListNode(1);
        node_1_1.next = node_1_2;

        SinglyLinkedListNode node_2_2 = new SinglyLinkedListNode(4);
        SinglyLinkedListNode node_2_1 = new SinglyLinkedListNode(3);
        node_2_1.next = node_2_2;

        SinglyLinkedListNode node_3_1 = new SinglyLinkedListNode(7);
        List<SinglyLinkedListNode> inputList = new ArrayList<>();

        inputList.add(node_1_1);
        inputList.add(node_2_1);
        inputList.add(node_3_1);

       SinglyLinkedListNode res = merge_k_lists(inputList);
        while(res != null){
            System.out.println(res.data);
            res = res.next;

        }

    }

}
