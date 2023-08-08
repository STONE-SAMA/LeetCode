package easy;

public class leetcode344 {
    /**
     * 反转字符串
     * https://leetcode.cn/problems/reverse-string/
     *
     * @param s
     */
    public void reverseString(char[] s) {
        int len = s.length;
        for (int i = 0; i < len / 2; i++) {
            char temp = s[i];
            s[i] = s[len - i - 1];
            s[len - i - 1] = temp;
        }
    }
}
