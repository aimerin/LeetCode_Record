package Dynamic.q518_Coin_Change2;

public class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        //二维dp数组的定义为
        //若只使用coins前i个硬币的面额，当金额为j时，有dp[i][j]种方法可以找零
        int[][] dp = new int[n + 1][amount + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= amount; j++) {
                if (j - coins[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j]
                            + dp[i][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][amount];
    }

    int change2(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <=amount; j++) {
                if (j - coins[i] >= 0) {
                    dp[j] = dp[j] + dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }
}