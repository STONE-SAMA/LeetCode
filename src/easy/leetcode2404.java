package easy;

import java.util.HashMap;
import java.util.Map;

public class leetcode2404 {
    /*
    出现最频繁的偶数元素
    https://leetcode.cn/problems/most-frequent-even-element/
     */
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (checkEven(nums[i])) {
                if (!map.containsKey(nums[i])) {
                    map.put(nums[i], 1);
                } else {
                    int temp = map.get(nums[i]);
                    map.put(nums[i], temp + 1);
                }
            }
        }
        int res = -1;
        int max = 0;
        for (Integer key : map.keySet()){
            int value = map.get(key);
            if (value > max){
                max = value;
                res = key;
            } else if (value == max) {
                if (key < res){
                    res = key;
                }
            }
        }
        return res;
    }

    private boolean checkEven(int x) {
        return x % 2 == 0;
    }
}
