package Stack.q20_Valid_Parentheses;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid1("{()}"));
    }
    //暴力破解
    public boolean isValid1(String s) {
        char[] ss=s.toCharArray();
        Stack<Character> stack=new Stack();
        for(int i=0;i<ss.length;i++){
            char c=ss[i];
            if(c=='{'||c=='['||c=='('){
                stack.push(c);
            }
            else{
                if(stack.isEmpty())return false;
                else{
                    if(c=='}'){
                        if(stack.peek().equals('{'))
                            stack.pop();
                        else return false;}
                    if(c==']'){
                        if(stack.peek().equals('['))
                            stack.pop();
                        else return false;}
                    if(c==')'){
                        if(stack.peek().equals('('))
                            stack.pop();
                        else return false;}
                }
            }
        }
        return s.isEmpty()?true:false;
//        Stack<Character> stack = new Stack<>();
//        char top = ' ';
//        char element = ' ';
//        for (int i = 0; i < s.length(); i++) {
//            element = s.charAt(i);
//            if(element=='('||element=='['||element=='{'){
//                stack.push(element);
//            }
//            if(element==')'){
//                top = stack.peek();
//                if(top=='('){
//                    stack.pop();
//                }else{
//                    return false;
//                }
//            }
//            if(element==']'){
//                top = stack.peek();
//                if(top=='['){
//                    stack.pop();
//                }else{
//                    return false;
//                }
//            }
//            if(element=='}'){
//                top = stack.peek();
//                if(top=='{'){
//                    stack.pop();
//                }else{
//                    return false;
//                }
//            }
//        }
//        if(stack.isEmpty())return true;
//        return false;
    }
    //
    private static final Map<Character,Character> map=new HashMap<Character,Character>(){
        {
            put('{','}');
            put('[',']');
            put('(', ')');
        }
    };

    public boolean isVaild(String s) {
        if (s.length() > 0 && !map.containsKey(s.charAt(0))) {
            return false;
        }
        LinkedList<Character> stack = new LinkedList<Character>(){{add('?');}};
        for(Character c : s.toCharArray()){
            if(map.containsKey(c)) stack.addLast(c);
            else if(map.get(stack.removeLast()) != c) return false;
        }
        return stack.size() == 1;

    }
}
