package com.suba.javaeg;

public class TestCharFinder {
    public static void main(String[] args) {

        CharFinder ch= new CharFinder();
        System.out.println(ch.findFirstNonReOccurance("a green apple"));
        ch.removeDuplicateSets();
        System.out.println(ch.findFirstReOccurance("a green apple"));

    }
}
