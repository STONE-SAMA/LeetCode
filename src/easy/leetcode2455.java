package easy;

public class leetcode2455 {
    /**
     * https://leetcode.cn/problems/average-value-of-even-numbers-that-are-divisible-by-three/
     * 可被三整除的偶数的平均值
     *
     * @param nums
     * @return
     */
    public int averageValue(int[] nums) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (temp % 2 == 0 && temp % 3 == 0) {
                sum += temp;
                count++;
            }
        }
        if (count == 0) {
            return 0;
        } else {
            return sum / count;
        }
    }
}
