package 数据结构;

import java.util.Stack;

public class 有效的括号 {

    public  boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '(' || chs[i] == '[' || chs[i] == '{') {
                stack.push(chs[i]);
            } else if (stack.isEmpty()) {
                return false;
            } else {
               if (chs[i] == ')' && stack.peek() != '(') {
                   return false;
               }
                if (chs[i] == ']' && stack.peek() != '[') {
                    return false;
                }
                if (chs[i] == '}' && stack.peek() != '{') {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
