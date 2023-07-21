package mid;

public class leetcode918 {
    /**
     * 环形子数组的最大和
     * https://leetcode.cn/problems/maximum-sum-circular-subarray/
     *
     * @param nums
     * @return
     */
    public int maxSubarraySumCircular(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        int min = 0;
        int max = sum[0];
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
            int temp = sum[i] - min;
            if (temp > max) {
                max = temp;
                index = i;
            }
            min = Math.min(min, sum[i]);
        }
        int last_max = 0;
        int sum_last = 0;
        for (int j = nums.length - 1; j > index; j--) {
            sum_last += nums[j];
            last_max = Math.max(last_max, sum_last);
        }
        return max + last_max;
    }
}
