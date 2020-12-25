package MergeIntervals.q56_Merger_Intervals;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Solution {
    public int[][] merge(int[][] intervals) {
        int resize = intervals.length;
        for (int i = 0; i < intervals.length-1; i++) {
            int[] interval_1 = intervals[i];
            int[] interval_2 = intervals[i + 1];
            if(interval_1[1]>interval_2[0]){//有合并区间
                interval_2[0] = interval_1[0];
                interval_1[0]=-1;
                resize--;
            }
        }
        int[][] ans = new int[resize][];
        int count=0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i] != null) {
                ans[count] = intervals[i];
                count++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        Solution solution = new Solution();
        int[][] re = solution.merge(intervals);
        for (int i = 0; i < re.length; i++) {
            int[] temp = re[i];
            for (int j = 0; j < temp.length; j++) {
                System.out.print(temp[i] + " ");
            }
            System.out.println();
        }
    }
}

