package easy;

public class leetcode2485 {

    /**
     * 找出中枢整数
     * https://leetcode.cn/problems/find-the-pivot-integer/
     *
     * @param n
     * @return
     */
    public int pivotInteger(int n) {
        int y = (n * n + n) / 2;
        int x = (int) Math.sqrt(y);
        return x * x == y ? x : -1;
    }
}
