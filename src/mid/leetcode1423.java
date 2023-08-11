package mid;

public class leetcode1423 {
    /**
     * 可获得的最大点数
     * https://leetcode.cn/problems/maximum-points-you-can-obtain-from-cards/
     *
     * @param cardPoints
     * @param k
     * @return
     */
    public int maxScore(int[] cardPoints, int k) {
        if (cardPoints.length == 1) {
            return cardPoints[0];
        }
        if (k == 1) {
            return Math.max(cardPoints[0], cardPoints[cardPoints.length - 1]);
        }
        int[] sum_k = new int[k + 1];//记录cardPoints中前k位的和,并第一位为0
        sum_k[0] = 0;
        for (int i = 1; i <= k; i++) {
            sum_k[i] = sum_k[i - 1] + cardPoints[i - 1];
        }
        int sum_back = 0;
        int ans = sum_k[k];
        for (int i = 0; i < k; i++) {
            sum_back += cardPoints[cardPoints.length - 1 - i];
            int temp = sum_k[k - i - 1] + sum_back;
            ans = Math.max(ans, temp);
        }
        return ans;
    }
}
