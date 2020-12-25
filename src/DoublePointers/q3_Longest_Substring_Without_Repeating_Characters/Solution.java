package DoublePointers.q3_Longest_Substring_Without_Repeating_Characters;

import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;
        char[] ss = s.toCharArray();

        while (right < ss.length) {
            char c = ss[right];
            right++;

            window.put(c, window.getOrDefault(c, 0) + 1);

            while (window.get(c) > 1) {
                char d = ss[left];
                left++;
                window.put(d, window.getOrDefault(d, 0) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.lengthOfLongestSubstring("au");
    }
}
