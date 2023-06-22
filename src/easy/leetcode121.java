package easy;

public class leetcode121 {
    /**
     * 买卖股票的最佳时机
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        //动态规划
        int res = 0;
        int len = prices.length;
        int[][] mark = new int[len][2];
        mark[0][0] = -prices[0];
        mark[0][1] = 0;
        for (int i = 1; i < len; i++) {
            mark[i][0] = Math.max(mark[i - 1][0], -prices[i]);
            mark[i][1] = Math.max(mark[i - 1][1], prices[i] + mark[i - 1][0]);
            if (mark[i][1]>res){
                res = mark[i][1];
            }
        }
        return res;
    }
}
