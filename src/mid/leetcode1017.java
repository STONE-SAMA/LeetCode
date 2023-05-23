package mid;

import java.util.Stack;

public class leetcode1017 {
    /*
    负二进制转换
    https://leetcode.cn/problems/convert-to-base-2/
     */
    public String baseNeg2(int n) {
        if (n == 0) {
            return "0";
        }
        Stack<Integer> stack = new Stack<>();

        while (n != 1) {
            int temp = Math.abs(n % (-2));
            stack.add(temp);
            if (n < 0) {
//                n = (int) Math.ceil(Math.abs(n)/2);
                if (n==-2){
                    n = 1;
                }else {
                    if (n % 2==0){
                        n = Math.abs(n / (-2));
                    }else {
                        n = Math.abs(n / (-2)) + 1;
                    }
                }
            } else {
                n = n / (-2);
            }
        }
        String res = "1";
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(-1/-2);
        leetcode1017 l = new leetcode1017();
//        String res = l.baseNeg2(19);
        String res = l.baseNeg2(8);
        System.out.println(res);
    }
}
