package mid;

public class leetcode53 {
    /**
     * 最大子数组和
     * https://leetcode.cn/problems/maximum-subarray/
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            dp[i + 1] = Math.max(dp[i] + nums[i], nums[i]);
        }
        int max = nums[0];
        for (int i = 1; i <= n; i++) {
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
