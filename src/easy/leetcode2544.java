package easy;

public class leetcode2544 {
    /**
     * 交替数字和
     * https://leetcode.cn/problems/alternating-digit-sum/
     *
     * @param n
     * @return
     */
    public int alternateDigitSum(int n) {
        String str = Integer.toString(n);
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            res += (str.charAt(i) - '0') * Math.pow(-1, i);
        }
        return res;
    }
}
