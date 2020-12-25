package Dynamic.q416_Partition_Equal_Subset_Sum;

public class Solution {
    /**
     * 使用二维dp数组，没有进行状态压缩
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //sum为奇数则必不可能分为两个元素和相等的子集
        if (sum % 2 != 0) return false;

        int n = nums.length;
        sum = sum / 2;

        //声明二维dp数组，dp数组定义如下：
        //dp[i][j]=x表示，对于前i个物品，当前背包容量为j时，若x为true，则背包恰好装满
        //x为false,则不能恰好将背包装满
        boolean[][] dp = new boolean[n + 1][sum + 1];
        //初始状态
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        //开始状态转移
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                //第i元素的质量为nums[i-1]
                if (j - nums[i - 1] < 0) {
                    //背包容量不足，肯定不能装入第i个物品
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //装入或不装入背包
                    //看看是否存在一种情况恰好能装满
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }

    //状态压缩
    public boolean canPartition2(int[] nums) {
        int sum = 0, n = nums.length;
        for (int num:nums) {
            sum += num;
        }
        if(sum%2!=0) return false;
        sum = sum / 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int i = 0; i <n; i++) {
            for (int j = sum; j>=0 ; j--) {
                if (j - nums[i] >= 0) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }
        return dp[sum];
    }
}
