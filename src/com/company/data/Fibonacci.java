package com.company.data;

public class Fibonacci {
    private static final int num = 45;
    private static final float goldenRatio = 1.61803398f;
    public static final int[] fibArray = generateFibArray();

    private static int[] generateFibArray() {
        int[] fib = new int[num];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i < num; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib;
    }
}
