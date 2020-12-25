package Array.q384_Shuffle_an_Array;

import java.util.Arrays;
import java.util.Random;

public class Solution {
    int [] nums;
    public Solution(int[] nums) {
        this.nums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] vshuffle = Arrays.copyOf(nums,nums.length);
        int size = vshuffle.length;
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int r = random.nextInt(size-i)+i;
            if(r!=i){
                int temp=vshuffle[i];
                vshuffle[i] = vshuffle[r];
                vshuffle[r]=temp;
            }
        }
        return vshuffle;
    }
}
