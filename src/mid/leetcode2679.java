package mid;

import java.util.Arrays;

public class leetcode2679 {
    /**
     * 矩阵中的和
     * https://leetcode.cn/problems/sum-in-a-matrix/
     *
     * @param nums
     * @return
     */
    public int matrixSum(int[][] nums) {
        int raw = nums.length;
        int col = nums[0].length;
        int sum = 0;
        for (int[] num : nums) {
            Arrays.sort(num);
        }
        for (int i = 0; i < col; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < raw; j++) {
                max = Math.max(max, nums[j][i]);
            }
            sum += max;
        }
        return sum;
    }
}
