package easy;

import java.util.ArrayList;
import java.util.List;

public class leetcode2399 {
    /*
    检查相同字母间的距离
    https://leetcode.cn/problems/check-distances-between-same-letters/
     */
    public boolean checkDistances(String s, int[] distance) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            if (!list.contains(c)) {
                list.add(c);
                int j = i + 1;
                for (; j < s.length(); j++) {
                    if (s.charAt(j) == c) {
                        break;
                    }
                }
                int index = c - 'a';
                if (distance[index] != j - i - 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
