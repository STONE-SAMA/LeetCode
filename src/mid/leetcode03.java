package mid;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class leetcode03 {
    /**
     * 无重复字符的最长子串
     * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }
        int res = 1;
        int step = -1;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (step + 1 < s.length() && !set.contains(s.charAt(step + 1))) {
                set.add(s.charAt(step + 1));
                step++;
            }
            res = Math.max(res, step - i + 1);
        }

        return res;
    }
}
