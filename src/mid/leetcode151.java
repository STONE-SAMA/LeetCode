package mid;

import java.util.Stack;

public class leetcode151 {
    /**
     * 反转字符串中的单词
     * https://leetcode.cn/problems/reverse-words-in-a-string
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        Stack<String> stack = new Stack<>();
        for (String str:strings){
            if (str.length()>0){
                stack.push(str);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
            if (stack.size()>0){
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        leetcode151 l = new leetcode151();
        String s = "  hello world  ";
        l.reverseWords(s);
    }
}
