package easy;

public class leetcode2600 {
    /**
     * K 件物品的最大和
     * https://leetcode.cn/problems/k-items-with-the-maximum-sum/
     *
     * @param numOnes
     * @param numZeros
     * @param numNegOnes
     * @param k
     * @return
     */
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (k <= numOnes) {
            return k;
        } else if (k <= numOnes + numZeros) {
            return numOnes;
        } else {
            return numOnes - (k - numOnes - numZeros);
        }
    }
}
