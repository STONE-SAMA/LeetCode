package easy;

import java.util.ArrayList;
import java.util.List;

public class leetcode1281 {
    /**
     * 整数的各位积和之差
     * https://leetcode.cn/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
     *
     * @param n
     * @return
     */
    public int subtractProductAndSum(int n) {
        List<Integer> list = new ArrayList<>();
        while (n / 10 != 0) {
            list.add(n % 10);
            n = n / 10;
        }
        list.add(n % 10);
        int sum = 0;
        int mul = 1;
        for (int num : list) {
            sum += num;
            mul *= num;
        }
        return mul - sum;
    }

    public static void main(String[] args) {
        leetcode1281 l = new leetcode1281();
        l.subtractProductAndSum(1234);
    }

}
