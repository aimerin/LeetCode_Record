package DivsionAndTreat.q34_Find_and_Last_Position_of_Element_in_Sorted_Array;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        int first = findFirst(nums, nums.length, target);
        int last = findLast(nums, nums.length, target);

        return new int[]{first, last};
    }

    public int findFirst(int[] nums, int len, int target) {
        if (len < 1) return -1;
        int low = 0;
        int high = len - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target && (mid - 1 < 0 || nums[mid - 1] != target)) {
                return mid;
            }
            if (nums[mid] >= target) {
                high = mid - 1;
            }
            if (nums[mid] < target) {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int findLast(int[] nums, int len, int target) {
        if(len<1)return -1;
        int low = 0;
        int high = len - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target && (mid+1>=len || nums[mid + 1] != target)) {
                return mid;
            }
            if (nums[mid] >= target) {
                high = mid - 1;
            }
            if (nums[mid] < target) {
                low = mid + 1;
            }
        }
        return -1;
    }
}
