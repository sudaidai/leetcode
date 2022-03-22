package com.company;

public class Lc1249 implements Answer{
    @Override
    public int getIndex() {
        return 1249;
    }

    public String minRemoveToMakeValid(String S) {
        char tag = '_'; // use this tag to replace invalid parentheses
        char[] ans = S.toCharArray();
        int len = S.length(), stIx = 0, i = 0, j = 0;
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
        stIx = 0;

        for (i = 0 ; j < len; j++) {
            if (j == stack[stIx]) stIx++;  // skip '(' if it is not matched
            else if (ans[j] != tag) ans[i++] = ans[j]; // skip all the tag we recognize invalid
        }
        return new String(ans, 0, i);
    }
}
