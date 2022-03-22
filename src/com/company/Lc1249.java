package com.company;

import java.util.Stack;

public class Lc1249 implements Answer{
    @Override
    public int getIndex() {
        return 1249;
    }

    public String minRemoveToMakeValid_1(String s) {
        char tag = '_'; // use this tag to replace invalid parentheses
        char[] ans = s.toCharArray();
        int len = s.length(), stIx = 0, i = 0, j = 0;
        int[] stack = new int[len+1];
        for (; i < len; i++) {
            if (ans[i] == ')') {
                // if the first char in the string is ')'
                if(stIx == 0) {
                    ans[i] = tag;
                } else {
                    stIx--;
                }
            } else if (ans[i] == '(') {
                stack[stIx++] = i;
            }
        }

        // now, if all the parentheses '(' are all matched, stIx is going to be 0
        // and stack will record one '(' pos at least
        stack[stIx] = -1;

        // initialize the stIx, since we would like to use it to skip '('
        stIx = 0;

        for (i = 0 ; j < len; j++) {
            if (j == stack[stIx]) stIx++;  // skip '(' if it is not matched
            else if (ans[j] != tag) ans[i++] = ans[j]; // skip all the tag we recognize invalid
        }
        return new String(ans, 0, i);
    }

    public String minRemoveToMakeValid_2(String s) {
        Stack<Integer> stack = new Stack<>();

        char tag = '_';
        char ch[] = s.toCharArray();

        for(int i = 0; i < ch.length; i++){
            if(ch[i] == '(') stack.push(i);
            else if(ch[i] == ')'){
                if(stack.isEmpty()) ch[i] = tag;
                else stack.pop();
            }
        }

        while(!stack.isEmpty()){
            ch[stack.pop()] = tag;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < ch.length; i++){
            if(ch[i] != tag) sb.append(ch[i]);
        }

        return sb.toString();
    }
}
