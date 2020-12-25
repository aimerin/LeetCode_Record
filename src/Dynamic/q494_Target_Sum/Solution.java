package Dynamic.q494_Target_Sum;

public class Solution {
    //回溯
    int result = 0;

    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0) return 0;
        backTrack(nums, 0, S);
        return result;
    }

    void backTrack(int[] nums, int i, int rest) {
        if (i == nums.length) {
            if (rest == 0) {
                result++;
            }
            return;
        }

        //给nums[i]选择负号
        rest += nums[i];
        backTrack(nums, i + 1, rest);
        //撤销选择
        rest -= nums[i];

        //给nums[i]选择正号
        rest -= nums[i];
        backTrack(nums, i + 1, rest);
        rest += nums[i];
    }

    //动态规划
    public int findTargetSumWays2(int[] nums, int S) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum < S || (sum + S) % 2 == 1) {
            return 0;
        }
        return subsets(nums, sum);
    }

    int subsets(int[] nums, int sum) {
        int n = nums.length;
        int[][] dp = new int[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
