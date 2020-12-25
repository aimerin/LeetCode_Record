package Array.q945_Minimum_Increment_to_Make_Array_Unique;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int re = solution.minIncrementForUnique2(new int[]{3,2,1,2,1,7});
        System.out.println(re);
    }
    int[] pos = new int[80000];
    
    public int minIncrementForUnique2(int[] A) {
        Arrays.fill(pos, -1);
        int move=0;
        //遍历每个数字a对其寻址得到的位置b，b比a的增量就是操作数
        for (int a:A) {
            int b = findPos(a);
            move+=b-a;
        }
        return move;
    }

    private int findPos(int a) {
        int b = pos[a];
        //如果a对应的位置pos[a]是空位，直接放入
        if (b == -1) {
            pos[a]=a;
            return a;
        }
        //向后寻址
        //因为pos[a]中标记了上次寻址得到的空位，因此从pos[a]+1开始寻址就行了（不需要从a+1开始）
        b = findPos(b + 1);
        // 寻址后的新空位要重新赋值给pos[a]哦，路径压缩就是体现在这里。
        pos[a]=b;
        return b;
    }
    public int minIncrementForUnique(int[] A) {
        int move = 0;

        Arrays.sort(A);
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[i - 1]) {
                int pre = A[i];
                A[i] = A[i - 1]+1;
                move+=A[i]-pre;
            }
        }
        return move;
    }
}
