package mid;

public class leetcode1921 {
    /**
     * 消灭怪物的最大数量
     * https://leetcode.cn/problems/eliminate-maximum-number-of-monsters
     *
     * @param dist
     * @param speed
     * @return
     */
    public int eliminateMaximum(int[] dist, int[] speed) {
        int len = dist.length;
        int[] time = new int[len];
        for (int i = 0; i < len; i++) {
            int temp = (dist[i] - 1) / speed[i];
            if (temp < len) {
                time[temp]++;
            }
        }
        int kill = 0;
        for (int i = 0; i < len; i++) {
            kill++;
            kill -= time[i];
            if (kill < 0) {
                return i + 1;
            }
        }
        return len;
    }
}
