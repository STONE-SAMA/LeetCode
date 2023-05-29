package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode2451 {
    /*
    差值数组不同的字符串
    https://leetcode.cn/problems/odd-string-difference/
     */
    public String oddString(String[] words) {
        var d = new HashMap<String, List<String>>();
        for (var s : words) {
            int m = s.length();
            var cs = new char[m - 1];
            for (int i = 0; i < m - 1; ++i) {
                cs[i] = (char) (s.charAt(i + 1) - s.charAt(i));
            }
            var t = String.valueOf(cs);
            d.computeIfAbsent(t, k -> new ArrayList<>()).add(s);
        }
        for (var ss : d.values()) {
            if (ss.size() == 1) {
                return ss.get(0);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        leetcode2451 l = new leetcode2451();
        String[] words = {"adc","wzy","abc"};
        String res = l.oddString(words);
        System.out.println(res);

    }
}
