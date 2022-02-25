package com.suba.workout.classproblems;


import java.util.*;

public class TestComparator {
    public static void main(String args[] ){
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,3,5,7,9,2,4,6,8, 3, 5));
        Collections.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 < o2) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        System.out.println(numbers);

    }

}
