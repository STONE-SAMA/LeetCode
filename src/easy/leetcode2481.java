package easy;

public class leetcode2481 {
    /**
     * 分割圆的最少切割次数
     * https://leetcode.cn/problems/minimum-cuts-to-divide-a-circle/
     *
     * @param n
     * @return
     */
    public int numberOfCuts(int n) {
        if (n == 1) {
            return 0;
        }
        if (n % 2 == 0) {
            return n / 2;
        } else {
            return n;
        }
    }
}
