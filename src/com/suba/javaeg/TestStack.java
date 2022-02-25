package com.suba.javaeg;

import java.util.Arrays;

public class TestStack {
    public static void main(String[] args) {
         var stack = new Stack(5);
         //stack.pop();
        stack.push(10);
         stack.push(20);
         stack.push(30);
         stack.push(40);
        stack.peek();
        System.out.println(stack.peek());
    }
}