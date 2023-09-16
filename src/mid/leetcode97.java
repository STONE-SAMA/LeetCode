package mid;

public class leetcode97 {
    /**
     * 交错字符串
     * https://leetcode.cn/problems/interleaving-string
     *
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();

        if (len1 + len2 < len3) {
            return false;
        }

        if (len3 == 0) {
            return true;
        }

        if ((len1 == 0 || len2 == 0) && len3 != 0){
            if (len1==0){
                return s2.equals(s3);
            }else {
                return s1.equals(s3);
            }
        }

        len1 = Math.min(len1, len3);
        len2 = Math.min(len2, len3);

        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        for (int i = 0; i < len1 + 1; i++) {
            for (int j = 0; j < len2 + 1; j++) {
                dp[i][j] = false;
            }
        }
        dp[0][0] = true;


        for (int i = 1; i <= len1; i++) {
            if (!dp[i - 1][0]) {
                dp[i][0] = false;
            } else {
                dp[i][0] = s1.charAt(i - 1) == s3.charAt(i - 1);
            }
        }

        for (int i = 1; i <= len2; i++) {
            if (!dp[0][i - 1]) {
                dp[0][i] = false;
            } else {
                dp[0][i] = s2.charAt(i - 1) == s3.charAt(i - 1);
            }
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (i + j > len3)
                    break;
                if (dp[i - 1][j] || dp[i][j - 1]) {
                    if (dp[i - 1][j] && dp[i][j - 1]) {
                        if (s3.charAt(i + j - 1) == s1.charAt(i - 1) || s3.charAt(i + j - 1) == s2.charAt(j - 1)) {
                            dp[i][j] = true;
                        }
                    } else {
                        if (dp[i][j - 1]) {
                            if (s3.charAt(i + j - 1) == s2.charAt(j - 1))
                                dp[i][j] = true;
                        }
                        if (dp[i - 1][j]) {
                            if (s3.charAt(i + j - 1) == s1.charAt(i - 1))
                                dp[i][j] = true;
                        }
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[len1][len2];
    }

    public static void main(String[] args) {
        leetcode97 l = new leetcode97();
//        String s1 = "aabcc";
//        String s2 = "dbbca";
//        String s3 = "aadbbcbcac";
        String s1 = "ab";
        String s2 = "bc";
        String s3 = "bbac";

        boolean res = l.isInterleave(s1, s2, s3);
        System.out.println(res);


    }
}
