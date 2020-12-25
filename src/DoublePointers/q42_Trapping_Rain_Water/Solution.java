package DoublePointers.q42_Trapping_Rain_Water;

public class Solution {
    public int trap(int[] height) {
        int ans=0;
        int size = height.length;
        for (int i = 1; i <size-1 ; i++) {
            int max_left=0,max_right=0;
            for (int j = i; j >=0 ; j--) {
                max_left = Math.max(height[j], max_left);
            }
            for (int j = i; j <size ; j++) {
                max_right = Math.max(height[j], max_right);
            }
            ans += Math.min(max_left, max_right) - height[i];
        }
        return ans;
    }

    public int trap2(int[] height) {
        int ans=0;
        int size = height.length;
        int[] max_left = new int[size];
        int[] max_right = new int[size];
        max_left[0] = height[0];
        max_right[size - 1] = height[size - 1];
        for (int i = 1; i <size ; i++) {
            max_left[i] = Math.max(height[i], max_left[i - 1]);
        }
        for (int i = size - 2; i >= 0; i++) {
            max_right[i] = Math.max(height[i], max_right[i + 1]);
        }
        for (int i = 1; i < size-1; i++) {
            ans += Math.min(max_left[i], max_right[i]) - height[i];
        }
        return ans;
    }

    //双指针
    public int trap3(int[] height) {
        int left = 0, right = height.length - 1;
        int ans=0;
        int left_max = height[0], right_max = height[height.length - 1];
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= left_max) {
                    left_max = height[left];
                }else{
                    ans += (left_max - height[left]);
                }
                ++left;
            }else{
                if (height[right] >=right_max) {
                    right_max = height[right];
                }else{
                    ans +=(right_max - height[right]);
                }
                --right;
            }
        }
        return ans;
    }
}
