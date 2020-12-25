package Dynamic.q118_PascalsTriangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.generate(5);
    }

    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        int[][] re = new int[numRows][];
        if(numRows>=1) re[0] = new int[]{1};
        if(numRows>=2) re[1] = new int[]{1, 1};

        for (int i = 2; i <numRows ; i++) {
            int temp=0;
            int[] last = re[i - 1];
            int[] row = new int[last.length + 1];
            for (int j = 0; j < row.length-1; j++) {
                row[j]=temp+last[j];
                temp = last[j];
            }
            row[row.length-1]=1;
            re[i]=row;
        }
        for (int i = 0; i < re.length; i++) {
            int[] cur = re[i];
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < cur.length; j++) {
                temp.add(cur[j]);
            }
            ans.add(temp);
        }
        return ans;
    }
}
