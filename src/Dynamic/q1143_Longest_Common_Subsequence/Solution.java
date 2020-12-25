package Dynamic.q1143_Longest_Common_Subsequence;

public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] str1 = text1.toCharArray();
        char[] str2 = text2.toCharArray();
        int m = str1.length;
        int n = str2.length;

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if(str1[i-1]==str2[j-1])
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }
}
