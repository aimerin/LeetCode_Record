package Dynamic.q62_Unique_Path2;

import java.awt.peer.ScrollbarPeer;

public class Solution {
    int[]pos=new int[2];
    int[] dest=new int[2];
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        dest[0] = obstacleGrid[0].length-1;
        dest[1]=obstacleGrid.length-1;
        pos[0]=0;
        pos[1]=0;
        int step=0;

        return 0;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int re = solution.uniquePathsWithObstacles2(new int[][]{{0,0,0},{0,1,0},{0,0,0}});
    }
    public void goRight(int[][] obstacleGrid) {
        int x=pos[0];
        int y = pos[1];
        if(x+1<obstacleGrid[0].length&&obstacleGrid[x+1][y]!=1){
            pos[0]=x+1;
        }
    }

    public void goDown(int[][] obstacleGrid) {
        int x=pos[0];
        int y = pos[1];
        if(y+1<obstacleGrid.length&&obstacleGrid[x][y+1]!=1){
            pos[1]=y+1;
        }
    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] f = new int[m];

        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; j++) {
                if(obstacleGrid[i][j]==1){
                    f[j]=0;
                    continue;
                }
                if(j-1>=0&&obstacleGrid[i][j-1]==0){
                    f[j] += f[j - 1];
                }

            }
        }
        return f[m - 1];
    }
}
