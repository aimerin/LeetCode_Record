package digit.q8_String_to_Integer;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        String s = " -42";
        Solution solution = new Solution();
        int re = solution.myAtoi(s);
        System.out.println(re);
    }
    public int myAtoi2(String s) {
        long res=0;
        int state=0;//state=0为初始状态，1为正整数状态，2为负整数状态
        for(int i=0;i<s.length();i++){
            char e=s.charAt(i);
            if(state==0&&e==' ')continue;
            else if(state==0&&e=='+')state=1;
            else if(state==0&&e=='-')state=2;
            else if(e>='0'&&e<='9'){
                if(state==0)state=1;
                int tmp=e-'0';
                res=res*10+tmp;
                if(res>Integer.MAX_VALUE)break;
            }
            else break;
        }
        if(state==1&&res>Integer.MAX_VALUE)res=Integer.MAX_VALUE;
        else if(state==2){
            res=-res;
            if(res<Integer.MIN_VALUE)res=Integer.MIN_VALUE;
        }
        return (int)res;

    }
    public int myAtoi(String s) {
        Automaton automaton = new Automaton();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            automaton.get(s.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }

    class Automaton {
        public int sign = 1;
        public long ans = 0;
        private String state = "start";
        private Map<String, String[]> table = new HashMap<String, String[]>() {{
            put("start", new String[]{"start", "signed", "in_number", "end"});
            put("signed", new String[]{"end", "end", "in_number", "end"});
            put("in_number", new String[]{"end", "end", "in_number", "end"});
            put("end", new String[]{"end", "end", "end", "end"});
        }};


        public void get(char c) {
            state = table.get(state)[get_col(c)];
            if ("in_number".equals(state)) {
                ans = ans * 10 + c - '0';
                ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
            } else if ("signed".equals(state)) {
                sign = c == '+' ? 1 : -1;
            }
        }

        private int get_col(char c) {
            if (c == ' ') {
                return 0;
            }
            if (c == '+' || c == '-') {
                return 1;
            }
            if (Character.isDigit(c)) {
                return 2;
            }
            return 3;
        }
    }


}
