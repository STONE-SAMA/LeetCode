package easy;

import java.util.Arrays;

public class leetcode2389 {
    /*
    和有限的最长子序列
    https://leetcode.cn/problems/longest-subsequence-with-limited-sum/
     */
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int temp = queries[i];
            int mark = 0;
            for (int j = 0; j < nums.length; j++) {
                if (temp - nums[j] >= 0) {
                    mark++;
                    temp -= nums[j];
                } else {
                    break;
                }
            }
            res[i] = mark;
        }
        return res;
    }
}
