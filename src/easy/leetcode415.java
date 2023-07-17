package easy;

import java.util.Stack;

public class leetcode415 {
    /**
     * 字符串相加
     * https://leetcode.cn/problems/add-strings/
     *
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (int i = 0; i < num1.length(); i++) {
            stack1.push(num1.charAt(i) - '0');
        }
        for (int i = 0; i < num2.length(); i++) {
            stack2.push(num2.charAt(i) - '0');
        }
        int pre = 0;//控制进位运算
        Stack<String> stringStack = new Stack<>();
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int temp = pre + stack1.pop() + stack2.pop();
            pre = 0;
            if (temp > 9) {
                temp = temp % 10;
                pre = 1;
            }
            stringStack.push(Integer.toString(temp));
        }
        while (!stack1.isEmpty()) {
            if (pre != 0) {
                int temp = pre + stack1.pop();
                if (temp > 9) {
                    temp = temp % 10;
                    pre = 1;
                } else {
                    pre = 0;
                }
                stringStack.push(Integer.toString(temp));
            } else {
                stringStack.push(Integer.toString(stack1.pop()));
            }
        }
        while (!stack2.isEmpty()) {
            if (pre != 0) {
                int temp = pre + stack2.pop();
                if (temp > 9) {
                    temp = temp % 10;
                    pre = 1;
                } else {
                    pre = 0;
                }
                stringStack.push(Integer.toString(temp));
            } else {
                stringStack.push(Integer.toString(stack2.pop()));
            }
        }

        StringBuilder sb = new StringBuilder();
        if (pre==1){
            sb.append(1);
        }
        while (!stringStack.isEmpty()) {
            sb.append(stringStack.pop());
        }
        return sb.toString();

    }
}
