package Dynamic.q1277_Count_Square_Submatrices_with_All_Ones;

public class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int res = 0;
        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]==1){
                    dp[i+1][j+1]=Math.min(Math.min(dp[i][j+1],dp[i+1][j]),dp[i][j])+1;
                    res += dp[i + 1][j + 1];
                }
            }
        }
        return res;
    }
}
