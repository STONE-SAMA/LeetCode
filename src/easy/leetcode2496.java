package easy;

public class leetcode2496 {
    /**
     * 数组中字符串的最大值
     * https://leetcode.cn/problems/maximum-value-of-a-string-in-an-array/
     *
     * @param strs
     * @return
     */
    public int maximumValue(String[] strs) {
        int max = 0;
        for (String str : strs) {
            int temp = 0;
            for (int i = 0; i < str.length(); i++) {
                if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
                    temp = str.length();
                    break;
                }
            }
            if (temp == 0) {
                temp = Integer.parseInt(str);
            }
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        leetcode2496 l = new leetcode2496();
        String[] strs = {"0001"};
        int res = l.maximumValue(strs);
        System.out.println(res);
    }
}
