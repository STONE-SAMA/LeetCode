package mid;

import java.util.HashSet;
import java.util.Set;

public class leetcode136 {

    /**
     * 只出现一次的数字
     * https://leetcode.cn/problems/single-number
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        int res = 0;
        for (int num : set) {
            res = num;
        }
        return res;
    }

}
