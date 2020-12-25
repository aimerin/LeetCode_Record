package Dynamic.q312_Burst_Balloons;


public class Solution {
    /**
     * @time 2020/12/22
     * @param nums
     * @return
     */
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] points = new int[n + 2];
        //添加两侧虚拟气球且将分数设置为1
        points[0] = points[n + 1] = 1;

        for (int i = 1; i <= n; i++) {
            points[i] = nums[i - 1];
        }

        //初始化dp数组 base case都为0
        //dp[i][j]的含义是戳破开区间(i,j)之间的所有气球所能获得的最高分数
        //假设最后一个被戳破的气球为k,所能获取的分数最高
        // 状态转移方程为：dp[i][j]=dp[i][k]+dp[k][j]+points[i]*points[j]*points[k]

        int[][] dp = new int[n + 2][n + 2];

        //遍历dp数组
        //从下到上，从左往右遍历
        for (int i = n; i >= 0; i--) {
            for (int j = i + 1; j < n + 2; j++) {
                //穷举(i,j)中应该戳破的气球k
                for (int k = i + 1; k < j; k++) {
                    //择优：即选取戳破后获得分数最高的气球k，使dp[i][j]最大
                    dp[i][j] = Math.max(dp[i][j],
                            dp[i][k] + dp[k][j] + points[i] * points[j] * points[k]);
                }
            }
        }
        return dp[0][n + 1];
    }
}
