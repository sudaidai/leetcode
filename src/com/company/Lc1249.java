package com.company;

import com.company.Answer;

import java.util.Stack;

/*
 * 1249. Minimum Remove to Make Valid Parentheses
 *
 * Given a string s of '(' , ')' and lowercase English characters.
 *
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.
 *
 * Formally, a parentheses string is valid if and only if:
 *
 * It is the empty string, contains only lowercase characters, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 */

public class Lc1249 implements Answer {
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

    public String minRemoveToMakeValid_2(String str) {
        Stack<Integer> stack = new Stack<>();

        char tag = '_';
        char cArray[] = str.toCharArray();

        for(int i=0 ; i<cArray.length ; i++){
            if(cArray[i] == '(') {
                stack.push(i);
            } else if(cArray[i] == ')') {
                if(stack.empty()) {
                    cArray[i] = tag;
                } else {
                    stack.pop();
                }
            }
        }

        while(!stack.empty()) {
            cArray[stack.pop()] = tag;
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0 ; i<cArray.length ; i++) {
            if(cArray[i] != tag) {
                sb.append(cArray[i]);
            }
        }

        return sb.toString();
    }
}
