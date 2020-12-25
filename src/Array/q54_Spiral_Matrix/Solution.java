package Array.q54_Spiral_Matrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> ans=new ArrayList<Integer>();

        int m=matrix.length;
        int n=matrix[0].length;

        int up=0,down=m-1,left=0,right=n-1;
        while(true){
            for(int i=left;i<=right;i++)ans.add(matrix[up][i]);
            if(++up>down)break;
            for(int i=up;i<=down;i++)ans.add(matrix[i][right]);
            if(--right<left)break;
            for(int i=right;i>=left;i--)ans.add(matrix[down][i]);
            if(--down<up)break;
            for(int i=down;i>=up;i--)ans.add(matrix[i][left]);
            if(++left>right)break;
        }

        return ans;
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans=new ArrayList<Integer>();

        int m=matrix.length;
        int n=matrix[0].length;
        int count=m*n;

        int i=0,j=0,di=0,dj=1;
        while(count--!=0){
            ans.add(matrix[i][j]);
            matrix[i][j]=101;
            if(matrix[(i+di+m)%m][(j+dj+n)%n]==101){
                int d=di;
                di=dj;
                dj=-d;
            }
            i+=di;
            j+=dj;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Solution solution = new Solution();
        List<Integer> list = solution.spiralOrder(matrix);
        System.out.println(list);

    }
}
