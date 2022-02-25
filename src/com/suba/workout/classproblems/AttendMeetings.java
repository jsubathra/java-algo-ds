package com.suba.workout.classproblems;

import java.util.*;

public class AttendMeetings {

    public static int can_attend_all_meetings(List<List<Integer>> intervals) {
        for(var interval : intervals){
            System.out.println(interval);
        }
        Collections.sort(intervals, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if(o1.get(0) - o2.get(0) !=0) {
                    return (int) (o1.get(0) - o2.get(0));
                }
                return (int)(o1.get(1) - o2.get(1));
            }
        });
        for(var interval : intervals){
            System.out.println(interval);
        }
        for(int i=0; i< intervals.size() - 1 ; i++){
            System.out.println(" End Time of First " + intervals.get(i).get(1));
            System.out.println(" Start Time of Second " + intervals.get(i+1).get(0));
            if(intervals.get(i).get(1)  > intervals.get(i+1).get(0)) {
               return 0;

            }
        }
        return 1;

    }

    public static void main(String[] args){
        List<Integer> meeting1 = new ArrayList<>(Arrays.asList(1,5));
        List<Integer> meeting2 = new ArrayList<>(Arrays.asList(5,7));

        List<Integer> meeting3 = new ArrayList<>(Arrays.asList(10,12));

        List<List<Integer>> intervals = new ArrayList<>();
        intervals.add(meeting1);
        intervals.add(meeting2);
        intervals.add(meeting3);
        if(can_attend_all_meetings(intervals) == 1)
            System.out.println("Can Attend All Meetings");
        else
            System.out.println("Cannot Attend All Meetings");





    }
}
