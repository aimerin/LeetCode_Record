package digit.q172_factorial_trailing_zeros;

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.trailingZeroes(13);

    }
    public int trailingZeroes(int n) {
       int zeroCount=0;
        for (int i = 5; i < n; i += 5) {
            int currentFactor=i;
            while (currentFactor % 5 == 0) {
                zeroCount++;
                currentFactor /= 5;
            }
        }
        return zeroCount;
    }
    public int trailingZeroes2(int n) {
        int count = 0;
        while(n >= 5) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }
}
