package easy;

public class leetcode2460 {
    /**
     * 对数组执行操作
     * https://leetcode.cn/problems/apply-operations-to-an-array/
     *
     * @param nums
     * @return
     */
    public int[] applyOperations(int[] nums) {
        int[] res = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] = 2 * nums[i];
                nums[i + 1] = 0;
            }
            if (nums[i] != 0) {
                res[index] = nums[i];
                index++;
            }
        }
        if (nums[nums.length - 1] != 0) {
            res[index] = nums[nums.length - 1];
        }
        return res;
    }
}
