package mid;

import java.util.Scanner;

public class leetcode213 {
    /**
     * 打家劫舍 II
     * https://leetcode.cn/problems/house-robber-ii
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        } else if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[len + 1];//不偷第一家
        for (int i = 1; i < len; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
        }
        int[] dp2 = new int[len];//不偷最后一家
        dp2[1] = nums[0];
        for (int i = 1; i < len - 1; i++) {
            dp2[i + 1] = Math.max(dp2[i], dp2[i - 1] + nums[i]);
        }
        return Math.max(dp[len], dp2[len - 1]);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        leetcode213 l = new leetcode213();
        int rob = l.rob(nums);
        System.out.println(rob);
    }

}
