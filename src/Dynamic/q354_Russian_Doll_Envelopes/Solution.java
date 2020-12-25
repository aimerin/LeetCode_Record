package Dynamic.q354_Russian_Doll_Envelopes;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = envelopes[i][1];
        }
        return lengthOfLIS(height);
    }

    public int lengthOfLIS(int[] nums) {
        int len = 1, n = nums.length;
        if(n==0)return 0;
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 1; i <n ; i++) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            }
            else{
                int l=1,r=len,pos=0;
                while (l <= r) {
                    int mid=(l+r)/2;
                    if(d[mid]<nums[i]){
                        pos=mid;
                        l=mid+1;
                    }else{
                        r=mid-1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }
}