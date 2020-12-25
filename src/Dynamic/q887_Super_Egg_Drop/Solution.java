package Dynamic.q887_Super_Egg_Drop;

import javafx.application.Application;
import javafx.stage.Stage;
import sun.java2d.pipe.SolidTextRenderer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int re = solution.superEggDrop(2, 100);
        System.out.println(re);
    }

    public int superEggDrop(int K, int N) {
        //dp[i][j]=一共有 i 层楼梯的情况下，使用 j 个鸡蛋的最少仍的次数
        int[][] dp = new int[N + 1][K + 1];

        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], i);
        }
        for (int i = 0; i <= K; i++) {
            dp[0][i] = 0;
        }

        dp[1][0] = 0;
        for (int i = 0; i <= K; i++) {
            dp[1][i] = 1;
        }
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 0;
            dp[i][1] = i;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                int left = 1;
                int right = i;
                while (left < right) {
                    int mid = left + (right - left + 1) / 2;
                    int breakCount = dp[mid - 1][j - 1];
                    int notBreakCount = dp[i - mid][j];
                    if (breakCount > notBreakCount) {
                        right = mid - 1;
                    } else {
                        left = mid;
                    }
                }
                dp[i][j] = Math.max(dp[left - 1][j - 1], dp[i - left][j]) + 1;
            }
        }
        return dp[N][K];
    }


    //Leetcode官方题解
    public int superEggDrop2(int K, int N) {
        return dp(K, N);
    }

    Map<Integer, Integer> memo = new HashMap<>();

//    public int dp(int K, int N) {
//        if (!memo.containsKey(N * 100 + K)) {
//            int ans;
//            if (N == 0) {
//                ans = 0;
//            } else if (K == 1) {
//                ans = N;
//            } else {
//                int lo = 1, hi = N;
//                while (lo + 1 < hi) {
//                    int x = (lo + hi) / 2;
//                    int t1 = dp(K - 1, x - 1);
//                    int t2 = dp(K, N - x);
//
//                    if (t1 < t2) {
//                        lo = x;
//                    } else if (t1 > t2) {
//                        hi = x;
//                    } else {
//                        lo = hi = x;
//                    }
//                }
//                ans = 1 + Math.min(
//                        Math.max(dp(K - 1, lo - 1),
//                                dp(K, N - lo)),
//                        Math.max(dp(K - 1, hi - 1),
//                                dp(K, N - hi)));
//
//            }
//            memo.put(N * 100 + K, ans);
//        }
//        return memo.get(N * 100 + K);
//    }

    public class Node{
        int K;
        int N;

        public Node(int K, int N) {

        }
    }
    //labuladong的解法
    public int superEggDrop3(int K, int N) {
        return dp(K, N);
    }

    public int dp(int K, int N) {
        if(K==1) return N;
        if(N==0) return 0;

        if (memo.containsKey(N * 100 +K)) {
            return memo.get(N * 100 +K);
        }

        int res = Integer.MAX_VALUE;

        int lo=1,hi=N;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int broken = dp(K - 1, mid - 1);
            int not_broken = dp(K, N - mid);

            if (broken > not_broken) {
                hi = mid - 1;
                res = Math.min(res, broken + 1);
            }
            else{
                lo = mid + 1;
                res = Math.min(res, not_broken+1);
            }
        }
        memo.put(N * 100 +K, res);
        return res;
    }
}
