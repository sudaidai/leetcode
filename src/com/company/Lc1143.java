package com.company;

/*
 * 1143. Longest Common Subsequence
 * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
 *
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
 *
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 */

public class Lc1143 implements Answer {

    @Override
    public int getIndex() {
        return 1143;
    }

    @Override
    public String getRoute() {
        return "longest-common-subsequence";
    }

    // n:  s1.length()
    // m:  s2.length()
    // TC: O(n*m)
    // SC: O(n*m)
    public int longestCommonSubsequence(String s1, String s2) {
        if(s1.equals(s2)) return s1.length();

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < s1.length(); ++i) {
            for (int j = 0; j < s2.length(); ++j) {
                if(s1.charAt(i) == s2.charAt(j)) dp[i+1][j+1] = 1 + dp[i][j];
                else dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
            }
        }
        return dp[s1.length()][s2.length()];
    }

    // n:  s1.length()
    // m:  s2.length()
    // TC: O(n*m)
    // SC: O(min(n, m))
    public int longestCommonSubsequence_2(String s1, String s2) {
        if(s1.equals(s2)) return s1.length();
        int m = s1.length(), n = s2.length();
        if (m < n) {
            return longestCommonSubsequence(s2, s1);
        }
        int[] dp = new int[n + 1];
        for (int i = 0; i < s1.length(); ++i) {
            for (int j = 0, prevRow = 0, prevRowPrevCol = 0; j < s2.length(); ++j) {
                prevRowPrevCol = prevRow;
                prevRow = dp[j + 1];
                dp[j + 1] = s1.charAt(i) == s2.charAt(j) ? prevRowPrevCol + 1 : Math.max(dp[j], prevRow);
            }
        }
        return dp[n];
    }
}
