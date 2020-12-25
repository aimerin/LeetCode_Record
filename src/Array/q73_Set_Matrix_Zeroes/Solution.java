package Array.q73_Set_Matrix_Zeroes;

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        Solution solution = new Solution();
        solution.setZeroes2(matrix);
    }
    public void setZeroes2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean row0=false,col0=false;
        //判断首行首列是否有0
        for(int i=0;i<m;i++){
            if(matrix[i][0]==0)
                col0=true;
        }
        for(int j=0;j<n;j++){
            if(matrix[0][j]==0)
                row0=true;
        }
        //从(1,1)开始向左下角扫描矩阵是否有0
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        for(int i=1;i<m;i++){
            if(matrix[i][0]==0){
                for(int j=1;j<n;j++){
                    matrix[i][j]=0;
                }
            }
        }

        for(int j=1;j<n;j++){
            if(matrix[0][j]==0){
                for(int i=1;i<m;i++){
                    matrix[i][j]=0;
                }
            }
        }

        if(col0){
            for(int i=0;i<m;i++){
                matrix[i][0]=0;
            }
        }
        if(row0){
            for(int j=0;j<n;j++){
                matrix[0][j]=0;
            }
        }
    }
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]==0){
                    visited[i][j]=true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]==0&&visited[i][j]==true){
                    for (int k = 0; k <n; k++) {
                        matrix[i][k]=0;
//                        visited[i][k] = true;
                    }
                    for (int k = 0; k < m; k++) {
                        matrix[k][j]=0;
//                        visited[k][j] = true;
                    }
                }
            }
        }
    }
}
