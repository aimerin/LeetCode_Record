package digit.q9_palindrome_number;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean re = solution.isPalindrome(131);
        System.out.println(re);
    }
    public boolean isPalindrome(int x) {
        if(x<0)return false;
        Deque<Integer> deque = new ArrayDeque<>();
        while(x!=0){
            deque.add(x % 10);
            x=x/10;
        }
        while (!deque.isEmpty()) {
            int i = deque.getFirst();
            int j = deque.getLast();
            if(i!=j)return false;
            deque.pollFirst();
            deque.pollLast();
        }
        return true;
    }
}
