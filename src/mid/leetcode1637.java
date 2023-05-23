package mid;

import java.util.Arrays;

public class leetcode1637 {
    /*
    两点之间不包含任何点的最宽垂直区域
    https://leetcode.cn/problems/widest-vertical-area-between-two-points-containing-no-points/
     */
    public int maxWidthOfVerticalArea(int[][] points) {
        int n = points.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = points[i][0];
        }
        Arrays.sort(nums);
        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            int temp = nums[i + 1] - nums[i];
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }
}
