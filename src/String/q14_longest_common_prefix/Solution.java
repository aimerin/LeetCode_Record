package String.q14_longest_common_prefix;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = strs[i].length() < prefix.length() ? strs[i] : prefix;
        }
        for (int i = 0; i < strs.length; ) {
            if (strs[i].substring(0,prefix.length()).contains(prefix)) {
                i++;
            }else{
                prefix = prefix.substring(0, prefix.length() - 1);
                i=0;
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String strs[] = {"flower","flow","flight"};
        Solution solution = new Solution();
        String re = solution.longestCommonPrefix(strs);
        System.out.println(re);
    }
}
