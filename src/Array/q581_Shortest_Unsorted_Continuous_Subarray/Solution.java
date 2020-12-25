package Array.q581_Shortest_Unsorted_Continuous_Subarray;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findUnsortedSubarray(new int[]{1,2,4,5,3});
        System.out.println();

    }
    //双指针
    public int findUnsortedSubarray(int[] nums) {
        int left=0,right=nums.length-1;
        while(left<nums.length-1&&nums[left]<=nums[left+1])left++;//持续右移
        while(right>0&&nums[right]>=nums[right-1])right--;//持续左移

        if(left<=right)return 0;

        //寻找中间无序数列的最大值和最小值
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = left; i <=right; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        //准备向两边扩散
        int start = left - 1, end = right + 1;
        while (start >= 0 && nums[start] > min) start--;//向左扩散
        while (end < nums.length && nums[end] < max) end++;//向右扩散
        //整个数组的最小值和最大值都在中间一段，所以整个数组都要排序
        if (start <= -1 && end >= nums.length) return nums.length;
        //只有最大值在中间一段
        if (start <= -1) return end;
        //只有最小值在中间一段
        if (end >= nums.length) return nums.length - start - 1;
        //最大值和最小值都不在中间一段，换句话说，最大值和最小值已分别在左右两段有序的部分
        return end - start - 1;
    }
}
