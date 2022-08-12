package com.company;

/*
 * 143. Reorder List
 *
 * You are given the head of a singly linked-list. The list can be represented as:
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 */

import java.util.Arrays;
import java.util.List;

public class Lc139 implements Answer {
    @Override
    public int getIndex() {
        return 139;
    }

    @Override
    public String getRoute() {
        return "word-break";
    }

    public boolean wordBreak(String s, List<String> dict) {
        boolean[] dp = new boolean[s.length() + 1]; // true if substring(0, i) is breakable
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public boolean wordBreak_2(String s, List<String> wordDict) {
        byte[] dp = new byte[s.length()];    // dp[i] = if possible to use words from wordDict to make s up to index i
        Arrays.fill(dp, (byte) -1);          // initialize all to -1 to indicate not calculated yet

        return wordBreak(s, 0, wordDict, dp);
    }

    private boolean wordBreak(String s, int index, List<String> wordDict, byte[] dp) {
        if (index >= s.length())                  // index past entire string already, means we found a solution
            return true;

        if (dp[index] != -1)
            return dp[index] == 1;               // decision here was using 1 to represent true, and 0 to represent false

        byte match = 0;
        for (int i = 0; i < wordDict.size(); i++) {
            String word = wordDict.get(i);
            if (s.startsWith(word, index) && wordBreak(s, index + word.length(), wordDict, dp)) {    // if the word starts at index, we recursively look for solution down this path
                match = 1;
                break;    // found a solution already so can break and skip work
            }
        }

        dp[index] = match;    // save result in dp for future use

        return match == 1;
    }
}
