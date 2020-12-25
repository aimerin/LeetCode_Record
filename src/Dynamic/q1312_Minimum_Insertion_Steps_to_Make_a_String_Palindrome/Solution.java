package Dynamic.q1312_Minimum_Insertion_Steps_to_Make_a_String_Palindrome;

public class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        char[] ss = s.toCharArray();
        int[] dp = new int[n];
        int temp = 0;
        for (int i = n - 2; i >= 0; i--) {
            int pre = 0;
            for (int j = i + 1; j < n; j++) {
                temp = dp[j];
                if (ss[i] == ss[j])
                    dp[j]=pre;
                else
                    dp[j] = Math.min(dp[j], dp[j - 1]) + 1;
            }
            pre = temp;
        }
        return dp[n - 1];
    }
}
