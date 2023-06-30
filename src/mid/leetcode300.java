package mid;


public class leetcode300 {
    /**
     * 最长递增子序列
     * https://leetcode.cn/problems/longest-increasing-subsequence
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int[] mark = new int[nums.length];
        mark[0] = 1;
        int res = mark[0];
        int min_index = 0;
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            if (temp <= nums[min_index]) {
                mark[i] = 1;
                min_index = i;
            } else {
                int max = 0;
                for (int j = 0; j < i; j++) {
                    if (nums[j] < temp) {
                        max = Math.max(max, mark[j]);
                    }
                }
                mark[i] = max + 1;
                res = Math.max(res, mark[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        leetcode300 l = new leetcode300();
        int[] nums = {4, 10, 4, 3, 8, 9};
        int res = l.lengthOfLIS(nums);
        System.out.println(res);
    }
}
