package Dynamic.q198_House_Robber;

import java.util.Arrays;

public class Solution {
    //自底向上
    public int rob(int[] nums) {
        int n = nums.length;
        //dp[i]=x表示
        //从第i间房子开始做选择，最多能取出的钱
        int[] dp = new int[n + 2];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
        }
        return dp[0];
    }

    public int rob2(int[] nums) {
        int n = nums.length;
        int dp_i_1 = 0, dp_i_2 = 0;
        int dp_i = 0;
        for (int i = n - 1; i >= 0; i--) {
            dp_i = Math.max(dp_i_1, nums[i] + dp_i_2);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i;
    }

    int[] memo;

    //自顶向下
    public int rob3(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dp(nums, 0);
    }

    int dp(int[] nums, int start) {
        if (start >= nums.length) {
            return 0;
        }
        if (memo[start] != -1) return memo[start];
        int res = Math.max(dp(nums, start + 1),
                nums[start] + dp(nums, start + 2));
        memo[start]=res;
        return res;
    }
}
