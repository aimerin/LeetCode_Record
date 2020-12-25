package Dynamic.q516_Longest_Palindromic_Subsequence;

import java.util.Arrays;

public class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        char[] ss = s.toCharArray();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = n-2; i >=0; i--) {
            for (int j = i+1; j < n; j++) {
                if (ss[i] == ss[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public int longestPalindromeSubseq2(String s) {
        int n = s.length();
        int[] dp = new int[n];
        char[] ss = s.toCharArray();
        Arrays.fill(dp, 1);

        for (int i = n - 2; i >= 0; i--) {
            int pre = 0;
            for (int j = i + 1; j < n; j++) {
                int temp = dp[j];
                if (ss[i]== ss[j]) {
                    dp[j] = pre + 2;
                }
                else{
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                pre = temp;
            }
        }
        return dp[n - 1];
    }
}
