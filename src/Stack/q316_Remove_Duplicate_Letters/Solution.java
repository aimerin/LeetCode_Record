package Stack.q316_Remove_Duplicate_Letters;

import java.util.Stack;

public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        Stack<Character> stk = new Stack<>();
        boolean[] inStack = new boolean[26];

        for (char c : s.toCharArray()) {
            count[c]--;
            if(inStack[c]) continue;

            while (!stk.isEmpty() && stk.peek() > c) {
                if (count[stk.peek()] == 0) {
                    break;
                }
                inStack[stk.pop()]=false;
            }
            stk.push(c);
            inStack[c] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }

        return sb.reverse().toString();
    }

}
