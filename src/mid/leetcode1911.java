package mid;

public class leetcode1911 {
    /**
     * 最大子序列交替和
     * https://leetcode.cn/problems/maximum-alternating-subsequence-sum/
     *
     * @param nums
     * @return
     */
    public long maxAlternatingSum(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        long[] dp1 = new long[nums.length + 1];//奇数个
        long[] dp2 = new long[nums.length + 1];//偶数个
        for (int i = 1; i <= nums.length; i++) {
//            dp[i] = Math.max(dp[i - 2] + nums[i] - nums[i - 1], Math.max(dp[i - 1], nums[i]));
            dp1[i] = Math.max(dp2[i - 1] - nums[i - 1], dp1[i - 1]);
            dp2[i] = Math.max(dp1[i - 1] + nums[i - 1], dp2[i - 1]);
        }
        return Math.max(dp1[nums.length], dp2[nums.length]);
    }

    public static void main(String[] args) {
        leetcode1911 l = new leetcode1911();
        int[] arr = {6, 2, 1, 2, 4, 5};
        long res = l.maxAlternatingSum(arr);
        System.out.println(res);
    }
}
