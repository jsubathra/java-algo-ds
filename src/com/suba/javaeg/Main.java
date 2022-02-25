package com.suba.javaeg;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //calMortgage();
        //BigOExamples bigO = new BigOExamples();
        // bigO.logNum();
       /* Array numbers = new Array(3);
        numbers.insert(10);
        numbers.insert(20);
        numbers.insert(30);
        numbers.insert(10);
        numbers.insert(50);
        numbers.print();
        numbers.removeAt(2);
        numbers.print();
        System.out.println(numbers.indexOf(10));
        System.out.println(numbers.lastIndexOf(50));

        System.out.println( numbers.contains(80) == true  ? "Element present" : "Not Available");*/

        ArrayCopy arr = new ArrayCopy(4);
        arr.addItem(5);
        arr.addItem(6);
        arr.addItem(7);
        arr.addItem(8);
        arr.addItem(7);
        arr.addItem(10);
        arr.print();

        arr.removeAt(0);
        System.out.println("Index Of :" + arr.indexOf(8));
        System.out.println("Last Index" + arr.lastIndex(7));


        //reverse(-123456);
    }

    private static void reverse(int number) {
        int remainder = 0;
        int reverse = 0;
        boolean isNegative = number < 0 ? true : false;
        number = Math.abs(number);
        while (number != 0) {
            remainder = number % 10;
            reverse = reverse * 10 + remainder;
            number = number / 10;

        }
        reverse = isNegative == true ? reverse * -1 : reverse;

        System.out.println("reverse " + reverse);
    }

    private static void calMortgage() {

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        double mortgageAmt = 0;
        int principal = 0;
        float annualRateOfInterest = 0.0F;
        float monthlyRateOfInterest = 0.0F;
        byte noOfYears = 0;
        int noOfMonths = 0;


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter Principal ($1K-$1M): ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000)
                break;
            System.out.print("Enter a number between 1000 and 1,000,000");
        }

        while (true) {

            System.out.print("Enter Annual Rate of Interest: ");
            annualRateOfInterest = scanner.nextFloat();
            if (annualRateOfInterest >= 1 && annualRateOfInterest <= 30) {
                monthlyRateOfInterest = annualRateOfInterest / PERCENT / MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30");


        }

        while (true) {
            System.out.print("Enter No: of Years: ");
            noOfYears = scanner.nextByte();
            if (noOfYears >= 1 && noOfYears <= 30) {
                noOfMonths = noOfYears * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30 for years");

        }

        mortgageAmt = principal
                * (monthlyRateOfInterest * Math.pow(1 + monthlyRateOfInterest, noOfMonths))
                / (Math.pow(1 + monthlyRateOfInterest, noOfMonths) - 1);

        String mortgageAmtFormatted = NumberFormat.getCurrencyInstance().format(mortgageAmt);
        System.out.println("Calculated Mortgage Amt: " + mortgageAmtFormatted);


    }
}
