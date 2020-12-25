package Dynamic.q300_Longest_Increasing_Subsequence;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
    }
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0)return 0;
        int[] dp = new int[nums.length];
        dp[0]=1;
        int maxans=1;
        for (int i = 1; i < nums.length; i++) {
            dp[i]=1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

    //贪心 + 二分查找
    public int lengthOfLIS2(int[] nums) {
        int len = 1, n = nums.length;
        if(n==0)return 0;
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 1; i <n ; i++) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            }
            else{
                int l=1,r=len,pos=0;
                while (l <= r) {
                    int mid=(l+r)/2;
                    if(d[mid]<nums[i]){
                        pos=mid;
                        l=mid+1;
                    }else{
                        r=mid-1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }
}
