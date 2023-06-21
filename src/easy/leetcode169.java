package easy;

import java.util.HashMap;

public class leetcode169 {
    /**
     * 多数元素
     * https://leetcode.cn/problems/majority-element
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (!map.containsKey(temp)) {
                map.put(temp, 1);
            } else {
                map.put(temp, map.get(temp) + 1);
            }
        }
        int max = 0;
        int res = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                res = key;
            }
        }
        return res;
    }
}
