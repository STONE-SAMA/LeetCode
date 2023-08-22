package mid;

import java.util.Collection;

public class leetcode238 {
    /**
     * 除自身以外数组的乘积
     * https://leetcode.cn/problems/product-of-array-except-self
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        left[0] = 1;
        int[] right = new int[len];
        right[len - 1] = 1;
        for (int i = 0; i < len - 1; i++) {
            left[i + 1] = left[i] * nums[i];
            right[len - i - 2] = right[len - i - 1] * nums[len - i - 1];
        }
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }

    public static void main(String[] args) {
        leetcode238 l = new leetcode238();
        int[] nums = {1, 2, 3, 4};
        int[] res = l.productExceptSelf(nums);
        for (int i : res) {
            System.out.printf(i + " ");
        }
    }
}
