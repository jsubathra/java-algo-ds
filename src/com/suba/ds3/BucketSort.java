package com.suba.ds3;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class BucketSort {

    public void sort(int[] array, int numberOfBuckets){
       // List<Integer>  x = new ArrayList<>();
        List<List<Integer>> buckets = new ArrayList<>();

        for(var i=0; i < numberOfBuckets; i++){
            buckets.add(new ArrayList<>()); // initialize the buckets
        }
        for(var item : array){
            buckets.get(item / numberOfBuckets).add(item);
        }

        for(var bucket : buckets) {
            Collections.sort(bucket); // use built in QS
            var i = 0;
            for (var item : bucket){
                array[i++] = item;
            }
        }
    }
}
