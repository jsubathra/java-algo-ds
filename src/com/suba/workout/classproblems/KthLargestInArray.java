package com.suba.workout.classproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargestInArray {
    public static int kth_largest_in_an_array(List<Integer> numbers, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(var item : numbers) {
            pq.offer(item);
            if (pq.size() > k)
                pq.poll();
        }
        return pq.peek();
    }

    public static void main(String[] args){
        var numbers = new ArrayList<Integer>(Arrays.asList(5, 1, 10, 3, 2));
        System.out.println(kth_largest_in_an_array(numbers,3));

    }
}
