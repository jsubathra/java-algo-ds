package com.suba.workout.classproblems;

import java.util.Arrays;

public class DutchNationalFlag {
    public static void dutch_flag_sort(char[] balls) {
        // logic
        // always check only for balls[greenptr] --
        // if it is blue swap blue Cnt with greenCnt, decrement only blueCnt
        // if red swap redCnt with GreenCnt and increment redCnt and decrement BlueCnt


        int redCnt = 0;
        int greenCnt = 0;
        int blueCnt = balls.length - 1;
        while(greenCnt <= blueCnt) {
            if (balls[greenCnt] == 'R') {
                swap(balls, redCnt, greenCnt);
                redCnt++;
                greenCnt++;
            } else if (balls[greenCnt] == 'B') {
                swap(balls, blueCnt, greenCnt);
                blueCnt--;
            } else if (balls[greenCnt] == 'G') {
                greenCnt++;
            }
        }

    }

    // If order asked is R, G , B then blue needs no swaps, G needs one swap and R needs 2 swaps
    public static void dutch_flag_sortWithLomitos(char[] balls) {
        int i = 0 ;
        int r = -1;
        int g =-1;
        while ( i <= balls.length -1){
//            if(balls[i] == 'B'){
//                //do nothing
//            } else
            if (balls[i] == 'G'){
                g++;
                swap(balls,g,i);
            } else if (balls[i] == 'R'){
                g++;
                swap(balls,g,i);
                r++;
                swap(balls,r,g);
            }
            i++;
        }

    }


        private static void swap(char[] array, int index1, int index2) {
        var temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args){
        char[] balls = {'G', 'B', 'G', 'G', 'R', 'B', 'R', 'G'};
       // dutch_flag_sort(balls);
        dutch_flag_sortWithLomitos(balls);
        System.out.println(Arrays.toString(balls));
        //Red Green Blue
    }
}
