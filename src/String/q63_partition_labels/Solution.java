package String.q63_partition_labels;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];//记录每个字母最后出现在字符串S的下标
        for (int i = 0; i < S.length(); i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<>();
        int start=0;
        int end = 0;
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end+1;
            }
        }
        return partition;
    }
}
