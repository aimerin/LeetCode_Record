package LinkList.q1_Two_Sum;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] nums=new int[]{-1,2,1,-4};
        int target=1;


        solution.threeSumClosest(nums, target);
    }
    public int[] twoSum(int i,int[] nums, int target) {
        Arrays.sort(nums);
        int lo=i,hi=nums.length-1;
        int[] re=new int[2];
        while(lo<hi){
            int sum=nums[lo]+nums[hi];
            int left=nums[lo],right=nums[hi];

            if(sum<target){
                while(lo<hi&&nums[lo]==left)lo++;
            }else if(sum>target){
                while(lo<hi&&nums[hi]==right)hi--;
            }else{
                re[0]=left;
                re[1]=right;
                break;
            }
        }
        return re;
    }

    public int threeSumClosest(int[] nums, int target) {
        int close=0;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++) {
            int left =0, right = nums.length - 1;
            while (left < right) {
                if(i==left||i==right)
                    continue;
                if(nums[left]+nums[right]<target){
                    close = target - (nums[left] + nums[right]+nums[i]);
                    left++;
                }
                if(nums[left]+nums[right]>target){
                    close = (nums[left] + nums[right]+nums[i]) - target;
                    right--;
                }
                if (nums[left] + nums[right] == target) {
                    close = 0;
                    break;
                }
            }
        }
        return close;
    }
    public int removeDuplicates(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        HashMap<Integer,Integer> maps=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int[] re = new int[set.size()];
        Iterator<Integer> iterator = set.iterator();
        int i=0;
        while (iterator.hasNext()) {
            re[i] = iterator.next();
            i++;
        }
        nums=re;
        return set.size();

    }
}
