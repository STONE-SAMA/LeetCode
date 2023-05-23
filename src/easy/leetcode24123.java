package easy;

public class leetcode24123 {
    /*
    最小偶倍数
    https://leetcode.cn/problems/smallest-even-multiple/
     */
    public int smallestEvenMultiple(int n) {
        if (n % 2 == 0) {
            return Math.max(n, 2);
        } else {
            return n * 2;
        }

    }
}
