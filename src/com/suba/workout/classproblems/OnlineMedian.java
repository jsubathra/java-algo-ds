package com.suba.workout.classproblems;
import java.io.PipedWriter;
import java.util.*;

public class OnlineMedian {

    public static List<Integer> online_median(List<Integer> stream) {
        var median = new ArrayList<Integer>();
        PriorityQueue<Integer> lowersMaxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -1 * o1.compareTo(o2);
            }
        });
        PriorityQueue<Integer> highersMinHeap = new PriorityQueue<Integer>();

        for(var i =0 ; i < stream.size() ; i++) {
            int item = stream.get(i);

            addnumber(item,lowersMaxHeap,highersMinHeap);
            rebalance(lowersMaxHeap,highersMinHeap);
            median.add(getMedian(lowersMaxHeap,highersMinHeap));
            System.out.println(median.get(i));

        }

        return median;
    }

    public static void addnumber(int item, PriorityQueue<Integer> lowers , PriorityQueue<Integer> highers){
        // When we add the number we check if it shd go to lower or higher
        if(lowers.size() == 0 || item < lowers.peek())
            lowers.add(item);
        else
            highers.add(item);
    }

    public static void rebalance( PriorityQueue<Integer> lowers , PriorityQueue<Integer> highers){
        //if odd number of elements pop from the bigger heap
        PriorityQueue<Integer> biggerSizeHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerSizeHeap= lowers.size() > highers.size() ? highers : lowers;

        if(biggerSizeHeap.size() - smallerSizeHeap.size() >= 2){
            smallerSizeHeap.add(biggerSizeHeap.poll());
        }
    }

    public static int getMedian( PriorityQueue<Integer> lowers , PriorityQueue<Integer> highers){
        PriorityQueue<Integer> biggerSizeHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerSizeHeap= lowers.size() > highers.size() ? highers : lowers;
        if(biggerSizeHeap.size() == smallerSizeHeap.size()){
            return (biggerSizeHeap.peek() + smallerSizeHeap.peek()) /2;
        } else
            return biggerSizeHeap.peek();

    }

    public static void main(String[] args){
        var numbers = new ArrayList<Integer>(Arrays.asList(3, 8, 5, 2));
        online_median(numbers);

    }
}
