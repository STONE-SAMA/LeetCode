package easy;

import java.util.HashMap;

public class leetcode290 {
    /**
     * 单词规律
     * https://leetcode.cn/problems/word-pattern
     *
     * @param pattern
     * @param s
     * @return
     */
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        String[] str = s.split(" ");
        if (str.length != pattern.length()) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char a = pattern.charAt(i);
            String s1 = str[i];
            if (map.containsKey(a)) {
                if (!map.get(a).equals(s1)) {
                    return false;
                }
            } else {
                for (String c : map.values()) {
                    if (c.equals(s1)) {
                        return false;
                    }
                }
                map.put(a, s1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        leetcode290 l = new leetcode290();
        String pattern = "abba";
        String s = "dog cat cat dog";
        boolean res = l.wordPattern(pattern, s);
        System.out.println(res);
    }
}
