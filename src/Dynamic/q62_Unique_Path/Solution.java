package Dynamic.q62_Unique_Path;

public class Solution {
    int m, n;
    int re;

    public int uniquePaths(int m,int n){
        int[][]dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==0){
                    dp[i][j]=1;
                }
                else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    void backtrack(int x, int y) {
        if (x == n - 1 && y == m - 1) {
            re++;
        }
        if(x<n) backtrack(x + 1, y);
        if(y<m)backtrack(x,y+1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int re = solution.uniquePaths(0, 0);
        System.out.println(re);
    }
}
