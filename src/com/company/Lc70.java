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

    public int climbStairs(int n) {
        int f1 = 1;
        int f2 = 1;
        for (int i = 0; i < n - 1; i++) {
            int temp = f1;
            f1 = f1 + f2;
            f2 = temp;
        }
        return f1;
    }

    Lc70(){
        genFib();
    }
    private final int size = 46;
    private int[] fib = new int[size];
    public void genFib() {
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 0; i < size - 2; i++) {
            fib[i + 2] = fib[i + 1] + fib[i];
        }
    }

    public int climbStairs_2(int n) {
        return fib[n];
    }

    /*
    Proof that
    To climbing stairs, if we can either climb 1 or 2 steps, then for climbing to the top n stair, there are
    F(n) denotes different ways to climb to the top for n belongs to N and F(n+2) = F(n+1) + F(n)

    for n = 1, F(3) = 3 = F(2) + F(1) = 2 + 1
    for n = k, there are k belongs to N and F(k+2) = F(k+1) + F(k)
    if we are at the k+2 stair, we just need climb 1 steps to k+3 stair and there are F(k+2) different ways.
    if we are at the k+1 stair, we have two ways to climb to k+3 stair, one is climb one step and therefore we are at k+2 stair to climb
    to k+3 stair, and the other is to climb 2 steps to k+3 stair, so for n = k+1, there are F(k+3) = F(k+2) + F(k+1) different ways
    to climb to the top
     */
}
