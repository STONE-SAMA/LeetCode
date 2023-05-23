package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class leetcode2418 {
    /*
    按身高排序
    https://leetcode.cn/problems/sort-the-people/
     */
    public String[] sortPeople(String[] names, int[] heights) {
        int len = names.length;
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < len; i++) {
            map.put(heights[i], i);
        }
        String[] res = new String[len];
        int index = len - 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res[index] = names[entry.getValue()];
            index--;
        }
        return res;
    }
}
