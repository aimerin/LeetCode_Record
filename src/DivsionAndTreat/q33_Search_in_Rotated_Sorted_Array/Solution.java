package DivsionAndTreat.q33_Search_in_Rotated_Sorted_Array;

import java.security.spec.RSAOtherPrimeInfo;

public class Solution {
    public static void main(String[] args) {

        int[] nums=new int[]{1,3};
        Solution solution = new Solution();
        int re=solution.search(nums,0);
        System.out.println(re);
    }
    public int search(int[] nums,int target,int left,int right){
        int mid=nums.length/2;
        if(left==right&&nums[mid]==target)return mid;
        if(left==right&&nums[mid]!=target)return -1;
        if(nums[0]<nums[mid]){
            //前半部分有序,进行二分查找
            int re=bisearch(nums,0,mid,target);
            if(re!=-1)return re;
        }
        else{
            //前半部分无序
            return search(nums,target,left,mid-1);
        }
        if(nums[mid]<nums[nums.length-1]){
            //后半部分有序
            int re=bisearch(nums,mid+1,nums.length-1,target);
            if(re!=-1)return re;
        }
        else{
            //前半部分无序
            return search(nums,target,mid,right);
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int n=nums.length;
        if(n==0){
            return -1;
        }
        if(n==1){
            return nums[0]==target?0:-1;
        }
        int left=0,right=n-1;
        while(left<=right){
            int mid = (left + right) / 2;
            if(nums[mid]==target){
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else{
                if (nums[mid] < target && target <= nums[n - 1]) {
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }
        return -1;

    }
    public int bisearch(int[] nums,int left,int right,int target){
        while(left<=right){
            int mid=(left+right)/2;
            if(target<nums[mid]){
                right=mid-1;
            }
            if(target>nums[mid]){
                left=mid+1;
            }
            if(target==nums[mid]){
                return mid;
            }
        }
        return -1;
    }
}
