package easy;

public class leetcode2582 {
    /**
     * 递枕头
     * https://leetcode.cn/problems/pass-the-pillow
     *
     * @param n
     * @param time
     * @return
     */
    public int passThePillow(int n, int time) {
        int k = time / (n - 1);
        int mod = time % (n - 1);
        return (k & 1) == 1 ? n - mod : mod + 1;
    }
}
