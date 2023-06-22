package mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode189 {
    /**
     * 轮转数组
     * https://leetcode.cn/problems/rotate-array
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        if (k % len == 0) {
            return;
        } else if (k > len) {
            k = k % len;
        }
        int[] arr1 = new int[len - k];
        int[] arr2 = new int[k];
        arr1 = Arrays.copyOfRange(nums, len - k, len);
        arr2 = Arrays.copyOfRange(nums, 0, len - k);
        int i = 0;
        for (; i < arr1.length; i++) {
            nums[i] = arr1[i];
        }
        for (int j = 0; j < arr2.length; j++) {
            nums[i] = arr2[j];
            i++;
        }
    }

    public static void main(String[] args) {
        leetcode189 l = new leetcode189();
        int[] arr = {-1, -100, 3, 99};
        l.rotate(arr, 2);
        for (int a : arr) {
            System.out.printf(a + " ");
        }
    }
}
