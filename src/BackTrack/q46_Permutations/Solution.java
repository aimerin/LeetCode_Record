package BackTrack.q46_Permutations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> re = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<Integer>();
        trackBack(nums, track);
        return re;
    }

    void trackBack(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            re.add(new LinkedList<>(track));
            return;
        }
        else{
            for (int i = 0; i < nums.length; i++) {
                if(track.contains(nums[i]))
                    continue;
                track.add(nums[i]);
                trackBack(nums, track);
                track.removeLast();
            }
        }
    }
}
