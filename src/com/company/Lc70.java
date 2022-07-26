package com.company;

/*
 * 70. Climbing Stairs
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */

public class Lc70 implements Answer {

    @Override
    public int getIndex() {
        return 70;
    }

    @Override
    public String getRoute() {
        return "climbing-stairs";
    }

    public static int climbStairs(int n) {
        int f1 = 1;
        int f2 = 1;
        for(int i = 0; i < n - 1; i++) {
            int temp = f1;
            f1 = f1 + f2;
            f2 = temp;
        }
        return f1;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(45));
    }
}
