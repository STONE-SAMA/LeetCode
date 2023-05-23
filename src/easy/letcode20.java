package easy;

import java.util.Stack;

public class letcode20 {
    /*
    有效的括号
    https://leetcode.cn/problems/valid-parentheses/
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()){
                    return false;
                }
                if (s.charAt(i) == ')') {
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else if (s.charAt(i) == ']') {
                    if (stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else if (s.charAt(i) == '}') {
                    if (stack.peek() == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        letcode20 l = new letcode20();
        boolean res = l.isValid("()");
        System.out.println(res);
    }
}
