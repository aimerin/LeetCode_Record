package DoublePointers.q438_Find_All_Anagrams_in_a_String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        char[] ss = s.toCharArray(), pp = p.toCharArray();
        int left = 0, right = 0;
        int valid = 0;

        for (char c:pp) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        ArrayList<Integer> re = new ArrayList<>();
        while (right < ss.length) {
            char c = ss[right];
            right++;

            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            while (right - left >= pp.length) {
                if (valid == need.size()) {
                    re.add(left);
                }
                char d = ss[left];
                left++;

                if (need.containsKey(d)) {
                    if (window.get(d) .equals(need.get(d)) ) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return re;
    }
}
