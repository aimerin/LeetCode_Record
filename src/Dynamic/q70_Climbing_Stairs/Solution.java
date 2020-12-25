package Dynamic.q70_Climbing_Stairs;

public class Solution {
    public int climbStairs(int n) {
        if(n==1)return 1;
        if(n==2)return 2;
        //爬上第一阶楼梯有一种方法，爬上第二阶的楼梯有两种方法
        //stair(n)=stair(n-1)+stair(n-2)
        int stair1=1,stair2=2,temp;
        //从第三节楼梯开始算到第n阶楼梯
        for (int i = 3; i <=n ; i++) {
            temp=stair1;
            stair1 = stair2;
            stair2 = stair2 + temp;
        }
        return stair2;
    }
}
