package BFS.q752_Open_the_Lock;

import javax.lang.model.element.NestingKind;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    //单向BFS
    public int openLock(String[] deadends, String target) {
        //记录要跳过的死亡数字
        Set<String> deads = new HashSet<>();
        for (String s : deadends) {
            deads.add(s);
        }

        //记录走过的路径
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        //从起点”0000“进行BFS
        int step = 0;
        q.add("0000");
        visited.add("0000");

        while (!q.isEmpty()) {
            int sz = q.size();

            for (int i = 0; i < sz; i++) {
                String cur = q.poll();

                /*判断密码是否是死亡数字*/
                if (deads.contains(cur)) {
                    continue;
                }
                /*判断是否到达终点*/
                if (cur.equals(target)) {
                    return step;
                }

                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }

            step++;
        }
        return -1;
    }

    //双向BFS
    public int openLock2(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        for (String s:deadends) {
            deads.add(s);
        }
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        Set<String> visited = new HashSet<>();

        q1.add("0000");
        q2.add(target);
        int step=0;

        while (!q1.isEmpty() && !q2.isEmpty()) {
            Set<String> temp = new HashSet<>();
            for (String cur:q1) {
                if(deads.contains(cur))
                    continue;
                if(q2.contains(cur))
                    return step;
                visited.add(cur);
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        temp.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) {
                        temp.add(down);
                    }
                }
            }
            step++;
            q1=q2;
            q2=temp;
        }
        return -1;
    }
    String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9') {
            ch[j] = '0';
        }
        else
            ch[j] += 1;
        return new String(ch);
    }

    String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if(ch[j]=='0'){
            ch[j] = '9';
        }
        else
            ch[j] -= 1;
        return new String(ch);
    }

}
