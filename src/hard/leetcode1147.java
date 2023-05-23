package hard;

public class leetcode1147 {
    /*
    段式回文
    https://leetcode.cn/problems/longest-chunked-palindrome-decomposition/
     */
    public int longestDecomposition(String text) {
        int k = 0;
        while (!text.isEmpty()) {
            int len = text.length();
            int mid = len / 2;
            int i = 1;
            while (i <= mid && !text.substring(0, i).equals(text.substring(len - i))) {
                i++;
            }
            if (i > mid) {
                k++;
                break;
            }
            k += 2;
            text = text.substring(i, len - i);
        }
        return k;
    }
}
