package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode228 {
    /**
     * 汇总区间
     * https://leetcode.cn/problems/summary-ranges
     *
     * @param nums
     * @return
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        if (nums.length == 1) {
            res.add(Integer.toString(nums[0]));
            return res;
        }
        for (int i = 0; i < nums.length; ) {
            int left = nums[i];
            i++;
            while (i < nums.length && nums[i] - nums[i - 1] == 1) {
                i++;
            }
            int right = nums[i - 1];
            if (right == left) {
                res.add(Integer.toString(left));
            } else {
                String str = Integer.toString(left) + "->" + Integer.toString(right);
                res.add(str);
            }
        }

        return res;
    }
}
