package mid;

import java.util.List;

public class leetcode139 {
    /**
     * 单词拆分
     * https://leetcode.cn/problems/word-break
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (String str : wordDict) {
                int len = str.length();
                if (dp[i] && (i + len) <= s.length() && s.substring(i, i + len).equals(str)) {
                    dp[i + len] = dp[i];
                }
            }
        }
        return dp[s.length()];
    }
}
