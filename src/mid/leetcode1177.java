package mid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class leetcode1177 {
    /**
     * 构建回文串检测
     * https://leetcode.cn/problems/can-make-palindrome-from-substring/
     *
     * @param s
     * @param queries
     * @return
     */
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> res = new ArrayList<>();
        int[][] count = new int[s.length() + 1][26];
        for (int i = 0; i < s.length(); i++) {
            count[i + 1] = count[i].clone();
            count[i + 1][s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            int k = queries[i][2];
            int flag = 0;
            for (int j = 0; j < 26; j++) {
                flag += (count[right + 1][j] - count[left][j]) % 2;
            }
            res.add(flag / 2 <= k);
        }
        return res;
    }


    public static void main(String[] args) {
        leetcode1177 l = new leetcode1177();
        String str = "hunu";
//        String subStr = str.substring(0, 5);
//        System.out.println(subStr);
//        int res = l.caculate(str);
//        System.out.println(res);
        int[][] queries = {{0, 3, 1}};
        List<Boolean> res = l.canMakePaliQueries(str, queries);
        System.out.println(res);
    }
}
