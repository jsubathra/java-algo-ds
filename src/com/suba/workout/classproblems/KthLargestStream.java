package com.suba.workout.classproblems;

import java.util.*;

public class KthLargestStream {


    public static List<Integer> kth_largest(int k, List<Integer> initial_stream,
                                            List<Integer> append_stream) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (var item : initial_stream)
            pq.offer(item);
        // remove elements that are smaller than k
        while (pq.size() > k)
            pq.poll();

        var result = new ArrayList<Integer>();

        for (var item : append_stream) {
            pq.offer(item);
            if (pq.size() > k)
                pq.poll();
            result.add(pq.peek());
        }

        return result;

    }

    public static void main(String[] args) {
        //Input: [1, 2, 3, 2, 4, 3, 1], 2
        var initialStream = new ArrayList<Integer>(Arrays.asList(4, 6, 7, 8));
        var appendStream = new ArrayList<Integer>(Arrays.asList(5, 2, 20));

        System.out.println(kth_largest(1, initialStream, appendStream));
    }
}
