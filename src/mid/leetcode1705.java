package mid;

import java.util.HashMap;
import java.util.Map;

public class leetcode1705 {
    /*
    面试题 17.05.  字母与数字
    https://leetcode.cn/problems/find-longest-subarray-lcci/
     */
    public String[] findLongestSubarray(String[] array) {
        int[] num = new int[array.length];
        if (array[0].charAt(0) >= '0' && array[0].charAt(0) <= '9') {
            num[0] = 1;
        } else {
            num[0] = -1;
        }
        for (int i = 1; i < array.length; i++) {
            if (array[i].charAt(0) >= '0' && array[i].charAt(0) <= '9') {
                num[i] = num[i - 1] + 1;
            } else {
                num[i] = num[i - 1] - 1;
            }
        }
        if (num[array.length - 1] == 0) {
            return array;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int max = 0, k = 0;
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(num[i])) {
                int j = map.get(num[i]);
                if (max < i - j) {
                    max = i - j;
                    k = j + 1;
                }
            }else {
                map.put(num[i], i);
            }
        }
        String[] ans = new String[max];
        for (int i = 0; i < max; i++) {
            ans[i] = array[k + i];
        }
        return ans;
    }

    public static void main(String[] args) {
        leetcode1705 l = new leetcode1705();
        String[] res = l.findLongestSubarray(new String[]{"A", "1", "B", "C", "D", "2", "3", "4", "E", "5", "F", "G", "6", "7", "H", "I", "J", "K", "L", "M"});
//        System.out.println(res);
        for (int i=0;i< res.length;i++){
            System.out.println(res[i]);
        }
    }
}
