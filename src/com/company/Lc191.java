package com.company;

/*
 * 191. Number of 1 Bits
 * Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
 *
 * Note:
 *
 * Note that in some languages, such as Java, there is no unsigned integer type. In this case, the input will be given as a signed integer type. It should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3, the input represents the signed integer. -3.
 */

public class Lc191 implements Answer {

    @Override
    public int getIndex() {
        return 191;
    }

    @Override
    public String getRoute() {
        return "number-of-1-bits";
    }

    public int hammingWeight(int n) {
        int ones = 0;
        while (n != 0) {
            ones += n & 1;
            n = n >>> 1;
        }
        return ones;
    }

    public int hammingWeight_2(int n) {
        int times = 0;
        while (n != 0) {
            n = n & (n - 1);
            times += 1;
        }
        return times;
    }
}
