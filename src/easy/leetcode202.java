package easy;

import java.util.ArrayList;
import java.util.List;

public class leetcode202 {
    /**
     * 快乐数
     * https://leetcode.cn/problems/happy-number
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        while (calculate(sum) != 1) {
            String s = String.valueOf(n);
            sum = 0;
            for (int i = 0; i < s.length(); i++) {
                sum += (s.charAt(i) - '0') * (s.charAt(i) - '0');
            }
            if (list.contains(sum)) {
                return false;
            } else {
                list.add(sum);
            }
            n = sum;
        }
        return true;
    }

    private int calculate(int num){
        String s = String.valueOf(num);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) - '0';
        }
        return sum;
    }


    public static void main(String[] args) {
        leetcode202 l = new leetcode202();
        boolean res = l.isHappy(19);
        System.out.println(res);
    }
}
