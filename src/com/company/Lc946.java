package com.company;

/*
 * 946. Validate Stack Sequences
 *
 * Given two integer arrays pushed and popped each with distinct values, return true if this could have been the result of a sequence of push and
 * pop operations on an initially empty stack, or false otherwise.
 */

import java.util.Stack;

public class Lc946 implements Answer {
    @Override
    public int getIndex() {
        return 946;
    }

    public boolean validateStackSequences_1(int[] pushed, int[] popped) {

        int len = pushed.length;
        Stack<Integer> stack = new Stack<>();
        int popIdx = 0;
        for(int e : pushed) {
            stack.push(e);
            while(!stack.empty() && stack.peek() == popped[popIdx]) {
                stack.pop();
                popIdx += 1;
            }
        }

        return len == popIdx;
    }

    public boolean validateStackSequences_2(int[] pushed, int[] popped) {

        int stkIdx = 0;
        int popIdx = 0;

        for(int e: pushed){
            pushed[stkIdx] = e;
            stkIdx++;
            while(stkIdx > 0 && pushed[stkIdx - 1] == popped[popIdx]){
                popIdx++;
                stkIdx--;
            }
        }

        return stkIdx == 0;
    }
}
