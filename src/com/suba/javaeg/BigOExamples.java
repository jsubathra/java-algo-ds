package com.suba.javaeg;

import java.util.Arrays;

public class BigOExamples {
    public void logNum(){
        int[] numbers = new int[3];
        System.out.println(numbers); // I@someadd
        System.out.println(Arrays.toString(numbers)); // wrap with arrays class and tostring elmts =0
        numbers[0] = 10;
        numbers[1]= 20;
        numbers[2] = 30;
        System.out.println(Arrays.toString(numbers)); // set to diff values
        int[] numbersNow = {40,50,60};
        System.out.println(Arrays.toString(numbersNow));
        System.out.println(numbersNow.length);
        // if you want to store 4 elements we need to create a big array and copy the existing
    }
}

