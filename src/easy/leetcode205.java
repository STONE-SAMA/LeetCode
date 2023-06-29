package easy;

import java.util.HashMap;

public class leetcode205 {
    /**
     * 同构字符串
     * https://leetcode.cn/problems/isomorphic-strings
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (map.containsKey(a)) {
                if (map.get(a) != b) {
                    return false;
                }
            } else {
                for (char c : map.values()) {
                    if (c == b) {
                        return false;
                    }
                }
                map.put(a, b);
            }
        }
        return true;
    }
}
