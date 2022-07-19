package com.company;

/*
 * 371. Sum of Two Integers
 * Given two integers a and b, return the sum of the two integers without using the operators + and -.
 */

public class Lc371 implements Answer {

    @Override
    public int getIndex() {
        return 371;
    }

    @Override
    public String getRoute() {
        return "sum-of-two-integers";
    }

    public static int getSum(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;
            System.out.println(Integer.toBinaryString(c));
            a = a ^ b;
            System.out.println(Integer.toBinaryString(a));
            b = c;
        }
        return a;
    }
}
