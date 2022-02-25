package com.suba.javaeg;

import java.util.Arrays;

public class Array {
    private int[] numbers;
    private int count; // this is used so if we create a big array but only few items to add

    // constructor to initialize array
    public Array(int length) {
        numbers = new int[length];
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(numbers[i]);
        }
    }

    // To Add items
    public void insert(int item) {
        // add item at the end of the array
        numbers[count] = item; // numbers[count++] can also be used // count is used is the last item of the index
        count++;
        // if array is full,  resize it ==> i
        // if lenght and count same them array is full == create a new bigger array and copy
        if (numbers.length == count) {
            //create new array twice the size
            int[] newNumbers = new int[count * 2];
            // copy all existing to new
            for (int i = 0; i < count; i++) {
                newNumbers[i] = numbers[i];
            }
            // set items to this newArray
            numbers = newNumbers;
        }
    }

    public int indexOf(int item) {
        for (int i = 0; i < count; i++) {
            if (numbers[i] == item)
                return i; // return index and not item
        }
        return -1; // return -1 if index not found
    }

    // remove Item at index
    public void removeAt(int index) {
        // Validate if valid index
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException();
        }
        // The items to left of index unchanges
        // items right of the index moves one step to left
        //[10,20,30]
        // To remove 20, 10 remains same , go to index 1 and copy item at index 2 to index 1
        for (int i = index; i < count; i++) {
            numbers[i] = numbers[i + 1];
        }
        // Shrink the array [10,20,30] == [10,20, ] = [10,20]
        count--;
    }

    public boolean contains(int item) {
        for (int i = 0; i < count; i++) {
            if (numbers[i] == item)
                return true;
        }
        return false;
    }

    public int lastIndexOf(int item) {
        // if item found store index
        int indexFound = -1;
        for (int i = 0; i < count; i++) {
            if (numbers[i] == item) {
                indexFound = i;
            }
        }
        return indexFound;

    }
}


