package Dynamic.q53_Maximum_Subarray;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int re = solution.maxSubArray(new int[]{0});
        System.out.println(re);
    }
    public int maxSubArray(int[] nums) {
        int pre = 0, max = nums[0];
        for (int x:nums) {
            pre = Math.max(pre + x, x);
            max = Math.max(pre, max);
        }
        return max;
    }
}
