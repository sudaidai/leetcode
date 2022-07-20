package com.company;

/*
 * 338. Counting Bits
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
 */

public class Lc338 implements Answer {

    @Override
    public int getIndex() {
        return 338;
    }

    @Override
    public String getRoute() {
        return "counting-bits";
    }

    public int[] countBits(int n) {
        int[] f = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            f[i] = f[i >>> 1] + (i & 1);
        }
        return f;
    }

    /*
     *  proof for binary number n, n have (floor(n/2) + n%2) 's bits with 1
     *  for k = 1, 1 have floor(1/2) + 1%2 = 1 's 1 entry.
     *  for k = n + 1, if floor(n / 2) + n % 2
     *  1. if n is even, then k have floor(n/2) + n%2 + 1 = floor(n+1 / 2) + 0 + 1 = floor(k/2) + k%2
     *  2. if n is odd, then k will be even and have the right most bit with 0, so it have floor(k/2)'s bits with 1 and (k+1)%2=0,
     *  so it comes k have floor(k/2) + k%2 's bits with 1
     */
}
