package easy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class letcode2341 {
    /*
    数组能形成多少数对
    https://leetcode.cn/problems/maximum-number-of-pairs-in-array/
     */
    public int[] numberOfPairs(int[] nums) {
        int[] res = {0, 0};
        int mark = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (map.containsKey(temp)) {
                int value = map.get(temp);
                map.replace(temp, value + 1);
            } else {
                map.put(temp, 1);
            }
        }
        // 带泛型的迭代器
//        Iterator<Map.Entry<Integer, Integer>> entries = map.entrySet().iterator();
//        while (entries.hasNext()) {
//            Map.Entry<Integer, Integer> entry = entries.next();
//            mark += entry.getValue() / 2;
//        }

        for (Integer value : map.values()){
            mark += value / 2;
        }

        res[0] = mark;
        res[1] = nums.length - 2 * mark;
        return res;
    }
}
