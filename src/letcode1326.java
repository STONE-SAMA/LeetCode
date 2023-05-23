public class letcode1326 {
    /*
    灌溉花园的最少水龙头数目
    https://leetcode.cn/problems/minimum-number-of-taps-to-open-to-water-a-garden/
     */
    public int minTaps(int n, int[] ranges) {
        // TODO
        int[] last = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            int l = Math.max(0, i - ranges[i]);//覆盖的左边界
            int r = i + ranges[i];//覆盖的右边界
            last[l] = Math.max(last[l], r);
        }
        int ans = 0, mx = 0, pre = 0;
        for (int i = 0; i < n; i++) {
            mx = Math.max(mx, last[i]);
            if (mx <= i) {
                return -1;
            }
            if (pre == i) {
                ans++;
                pre = mx;
            }
        }
        return ans;
    }
}
