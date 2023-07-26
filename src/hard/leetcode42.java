package hard;

public class leetcode42 {
    /**
     * 接雨水
     * https://leetcode.cn/problems/trapping-rain-water/
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int max_index = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] >= height[max_index]) {
                max_index = i;
            }
        }
        //获取最高点位置，分别从左右两边向最高点遍历，获取雨水值
        int res = 0;
        int left = 0;
        int left_index = 0;
        int sum = 0;
        for (int i = 0; i <= max_index; i++) {
            int temp = height[i];
            if (temp >= left) {
                res += (i - left_index) * left - sum;
                left_index = i;
                left = temp;
                sum = temp;
            } else {
                sum += temp;
            }
        }
        int right_index = height.length - 1;
        int right = 0;
        sum = 0;
        for (int j = height.length - 1; j >= max_index; j--) {
            int temp = height[j];
            if (temp >= right) {
                res += (right_index - j) * right - sum;
                right_index = j;
                right = temp;
                sum = temp;
            } else {
                sum += temp;
            }
        }
        return res;
    }
}
