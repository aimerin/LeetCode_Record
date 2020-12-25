package digit.q7_reserve_integer;

import java.util.Stack;

public class Solution {
    public int reverse(int x) {
        Stack<Integer> stack = new Stack<>();
        while (x != 0) {
            stack.push(x % 10);
            x = x / 10;
        }
        int re=0;
        int chengzi = 1;
        while (!stack.isEmpty()) {
            re+=stack.pop()*chengzi;
            chengzi = chengzi * 10;
        }
        return re;
    }

    public int reverse1(int x) {
        long n = 0;
        while(x != 0) {
            n = n*10 + x%10;
            x = x/10;
        }
        return (int)n==n? (int)n:0;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int re=solution.reverse(123);
        System.out.println(re);
    }
}
