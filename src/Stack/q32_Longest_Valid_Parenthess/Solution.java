package Stack.q32_Longest_Valid_Parenthess;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int re = solution.longestValidParentheses("()(()");
        System.out.println(re);

    }
    public int longestValidParentheses(String s) {
        int size = s.length();
        int dp[] = new int[size];

        int maxVal=0;
        for (int i = 1; i < size; i++) {
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='('){
                    dp[i]=2;
                    if(i-2>=0){
                        dp[i] = dp[i] + dp[i - 2];
                    }
                } else if (dp[i - 1] > 0) {
                    if ((i - dp[i - 1] - 1) >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i]=dp[i-1]+2;
                        if ((i - dp[i - 1] - 2) >= 0) {
                            dp[i] = dp[i] + dp[i - dp[i - 1] - 2];
                        }
                    }
                }
            }
            maxVal = Math.max(maxVal, dp[i]);
        }
        return maxVal;
    }


}
