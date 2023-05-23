package mid;

import java.util.ArrayList;
import java.util.List;

public class leetcode1023 {
    /*
    驼峰式匹配
    https://leetcode.cn/problems/camelcase-matching/
     */
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> list = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            list.add(check(queries[i], pattern));
        }
        return list;
    }

    private boolean check(String query, String pattern) {
        int q = 0;
        int p = 0;
        while (q < query.length() && p < pattern.length()) {
            char temp_q = query.charAt(q);
            char temp_p = pattern.charAt(p);
            if (temp_q == temp_p) {
                q++;
                p++;
            } else {
                if (temp_q <= 'z' && temp_q >= 'a') {
                    q++;
                } else {
                    return false;
                }
            }
        }
        while (q < query.length()) {
            char temp = query.charAt(q);
            if (temp >= 'A' && temp <= 'Z') {
                return false;
            }
            q++;
        }
        return p == pattern.length();
    }

    public static void main(String[] args) {
        leetcode1023 l = new leetcode1023();
        String[] queries = {"FrameBar", "FooBarTest"};
        String pattern = "FB";
        List<Boolean> res = l.camelMatch(queries, pattern);
        for (boolean v : res) {
            System.out.println(v);
        }
    }
}
