package Array.q78_Subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] nums=new int[]{1, 2, 3};
        Solution solution = new Solution();
        solution.subsets(nums);

    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        res.add(new ArrayList<>());
        for(int i=0;i<nums.length;i++){
            int size=res.size();
            for(int j=0;j<size;j++){
                List<Integer>tmp=new ArrayList<>(res.get(j));
                tmp.add(nums[i]);
                res.add(tmp);
            }
        }
        return res;
    }
}
