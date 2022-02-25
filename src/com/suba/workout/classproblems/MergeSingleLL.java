package com.suba.workout.classproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSingleLL {

    public static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }

        @Override
        public String toString() {
            return "SinglyLinkedListNode{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    public static SinglyLinkedListNode merge_k_lists(List<SinglyLinkedListNode> lists) {
        //        1,3,5,3,4,7
        List<Integer> list = new ArrayList<>();
        for (SinglyLinkedListNode input : lists) {
            var current = input;
            while (current != null) {
                list.add(current.data);
                current = current.next;
            }
//            list.add(current.data);
        }

        int[] intArray = list.stream().mapToInt(Integer::intValue).toArray();
        quickSort(intArray);
        SinglyLinkedListNode result = null;
        if (intArray.length > 0) {
             result = new SinglyLinkedListNode(intArray[0]);
            var current = result;
            for (var i = 1; i < intArray.length; i++) {
                current.next = new SinglyLinkedListNode(intArray[i]);
                current = current.next;
            }
        }
        return result;

    }

    public static void main(String[] args) {

        // [[1,3,5],[3,4],[7]
        SinglyLinkedListNode node_1_3 = new SinglyLinkedListNode(5);
        SinglyLinkedListNode node_1_2 = new SinglyLinkedListNode(3);
        node_1_2.next = node_1_3;
        SinglyLinkedListNode node_1_1 = new SinglyLinkedListNode(1);
        node_1_1.next = node_1_2;

        SinglyLinkedListNode node_2_2 = new SinglyLinkedListNode(4);
        SinglyLinkedListNode node_2_1 = new SinglyLinkedListNode(3);
        node_2_1.next = node_2_2;

        SinglyLinkedListNode node_3_1 = new SinglyLinkedListNode(7);

//        var current = node_2_1;
//        while (current.next != null) {
//            System.out.println(current.data);
//            current = current.next;
//        }
//        System.out.println(current.data);

        List<SinglyLinkedListNode> inputList = new ArrayList<>();
//        inputList.add(null);

        inputList.add(node_1_1);
        inputList.add(node_2_1);
        inputList.add(node_3_1);

//        for (SinglyLinkedListNode s : inputList) {
//            System.out.println(s.data + " -> " + s.next);
//        }

        System.out.println(merge_k_lists(inputList));

    }

    public static void swap(int[] array, int index1, int index2) {
        var temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void quickSort(int array[]) {
        quickSortHelperLomutos(array, 0, array.length - 1);

    }

    private static void quickSortHelperLomutos(int[] array, int start, int end) {
        if (start >= end)
            return;

        var randomIndex = Math.floor(Math.random() * (end - start + 1) + start);

        swap(array, start, (int) randomIndex);
        var pivot = array[start];


        int smaller = start;
        int bigger = start;

        for (bigger = start + 1; bigger <= end; bigger++) { //20, 40, 10, 60, 50 -> 20, 10, 40, 60, 50
            if (array[bigger] < pivot) {
                smaller++;
                swap(array, smaller, bigger);
            }
        }
        swap(array, start, smaller);

        quickSortHelperLomutos(array, start, smaller - 1);
        quickSortHelperLomutos(array, smaller + 1, end);
    }
}
