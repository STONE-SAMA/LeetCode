package mid;

public class leetcode1749 {
    /**
     * 任意子数组和的绝对值的最大值
     * https://leetcode.cn/problems/maximum-absolute-sum-of-any-subarray/
     *
     * @param nums
     * @return
     */
    public int maxAbsoluteSum(int[] nums) {
        int[] arr_max = new int[nums.length + 1];
        int[] arr_min = new int[nums.length + 1];
        arr_max[0] = 0;
        arr_min[0] = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            arr_max[i + 1] = Math.max(arr_max[i], 0) + nums[i];
            arr_min[i + 1] = Math.min(arr_min[i], 0) + nums[i];

            ans = Math.max(ans, Math.max(arr_max[i + 1], Math.abs(arr_min[i + 1])));
        }
        return ans;
    }

}
