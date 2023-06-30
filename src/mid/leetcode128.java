package mid;

import java.util.HashSet;

public class leetcode128 {
    /**
     * 最长连续序列
     * https://leetcode.cn/problems/longest-consecutive-sequence
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        int count = 0;
        for (int x : set) {
            if (!set.contains(x - 1)) {
                count = 0;
                for (int i = x; ; i++) {
                    if (set.contains(i)) {
                        count++;
                    } else {
                        res = Math.max(res, count);
                        break;
                    }
                }
            }
        }
        res = Math.max(res, count);
        return res;
    }

    public static void main(String[] args) {
        leetcode128 l = new leetcode128();
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int i = l.longestConsecutive(nums);
        System.out.println(i);
    }
}
