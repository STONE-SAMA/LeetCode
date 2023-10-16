package mid;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class leetcode137 {

    /**
     * 只出现一次的数字 II
     * https://leetcode.cn/problems/single-number-ii
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int res = 0;
        Iterator<Integer> it = map.keySet().iterator();
        while (it.hasNext()) {
            int key = it.next();
            if (map.get(key) == 1) {
                res = key;
                break;
            }
        }
        return res;
    }

}
