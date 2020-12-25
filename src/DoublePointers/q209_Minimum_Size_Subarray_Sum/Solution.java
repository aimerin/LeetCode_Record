package DoublePointers.q209_Minimum_Size_Subarray_Sum;

import edu.princeton.cs.algs4.In;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minSubArrayLen(4, new int[]{1, 4, 4});
    }
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length<=1){
            return 0;
        }

        int ans=Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum=0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if(sum>=s){
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }

    //双指针
    public int minSubArrayLen2(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        int start,end;
        start=end=0;
        int sum=0;
        while (end < n) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start+1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
