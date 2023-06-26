package mid;

public class leetcode122 {
    /**
     * 买卖股票的最佳时机 II
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int bonus = 0;
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int before = prices[0];
        for (int i = 1; i < len; i++) {
            if (prices[i] > before) {
                bonus += prices[i] - before;
            }
            before = prices[i];
        }
        return bonus;
    }
}
