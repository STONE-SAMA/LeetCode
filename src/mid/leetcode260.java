package mid;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class leetcode260 {

    /**
     * 只出现一次的数字 III
     * https://leetcode.cn/problems/single-number-iii
     *
     * @param nums
     * @return
     */
    public int[] singleNumber(int[] nums) {

        int[] res = new int[2];

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        int count = 0;
        for (int value : set) {
            res[count] = value;
            count++;
        }


//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) {
//            if (map.containsKey(num)) {
//                map.put(num, map.get(num) + 1);
//            } else {
//                map.put(num, 1);
//            }
//        }
//        int count = 0;
//        for (int key : map.keySet()) {
//            if (map.get(key) == 1) {
//                res[count] = key;
//                count++;
//            }
//        }
        return res;

    }

}
