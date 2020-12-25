package DoublePointers.q76_Minimum_Window_Substring;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {

    }

    public String minWindow(String s, String t) {
        int[] window = new int[128];
        int[] need = new int[128];
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int count = 0, min = ss.length;
        String res = "";
        for (int i = 0; i < tt.length; i++) {
            need[tt[i]]++;
        }
        int i=0,j=0;
        while (j < ss.length) {
            char c = ss[j];
            window[c]++;
            if(window[c]<=need[c]) count++;
            while (count == tt.length) {
                if (j - i + 1 <= min) {
                    res = s.substring(i, j + 1);
                    min = j - i + 1;
                }
                window[ss[i]]--;
                if(window[ss[i]]<need[ss[i]]) count--;
                i++;
                if(i>=ss.length) break;
            }
            j++;
        }
        return res;
    }


}
