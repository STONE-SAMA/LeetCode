package mid;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class leetcode1048 {
    /*
    最长字符串链
    https://leetcode.cn/problems/longest-string-chain/
     */
    public int longestStrChain(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        int res = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            map.put(s, 1);
            for (int i = 0; i < s.length(); i++) {
                String pre = s.substring(0, i) + s.substring(i + 1);
                if (map.containsKey(pre)) {
                    map.put(s, Math.max(map.get(s), map.get(pre) + 1));
                }
            }
            res = Math.max(res, map.get(s));
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"};
        leetcode1048 l = new leetcode1048();
        l.longestStrChain(words);
    }
}
