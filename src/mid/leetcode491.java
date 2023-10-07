package mid;

import java.util.ArrayList;
import java.util.List;

public class leetcode491 {

    /**
     * 递增子序列
     * https://leetcode.cn/problems/non-decreasing-subsequences/description/
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        //回溯
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        int pre = -1000;
        for (int i = 0; i < len; i++) {
            int temp = nums[i];
            if (temp == pre) {
                continue;
            } else {
                for (int j = 2; j < len - i; j++) {

                }

            }
        }

        return res;
    }
}
