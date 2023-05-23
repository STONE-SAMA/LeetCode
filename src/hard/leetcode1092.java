package hard;

public class leetcode1092 {
    /*
    最短公共超序列
    https://leetcode.cn/problems/shortest-common-supersequence/
     */
    public String shortestCommonSupersequence(String str1, String str2) {
        String long_str;
        String short_str;
        if (str1.length() > str2.length()) {
            long_str = str1;
            short_str = str2;
        } else if (str1.length() < str2.length()){
            long_str = str2;
            short_str = str1;
        } else {
            if (str1.contains(str2)){
                return str1;
            }
            String res_1 = superSequence(str1, str2);
            String res_2 = superSequence(str2, str1);
            return res_1.length()<=res_2.length() ? res_1 : res_2;
        }
        if (long_str.contains(short_str)) {
            return long_str;
        }
        String res = superSequence(short_str, long_str);
        return res;
    }

    private String superSequence(String short_str, String long_str){
        int left = 1;
        int mark_left = -1;//左侧添加字符数量
        for (; left < short_str.length(); left++) {
            boolean flag = true;
            for (int i = 0; i < short_str.length() - left; i++) {
                if (long_str.charAt(i) != short_str.charAt(i + left)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                mark_left = left;
                break;
            }
        }
        if (mark_left == -1) {
            mark_left = short_str.length();
        }

        int right = 1;
        int mark_right = -1;
        for (; right < short_str.length(); right++) {
            boolean flag = true;
            for (int j = 0; j < short_str.length() - right; j++) {
                if (long_str.charAt(long_str.length() -1 - j) != short_str.charAt(short_str.length() -1 - j - right)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                mark_right = right;
                break;
            }
        }
        if (mark_right == -1) {
            mark_right = short_str.length();
        }
        String res;
        if (mark_left <= mark_right) {
            String left_str = short_str.substring(0, mark_left);
            res = left_str + long_str;
        } else {
            String right_str = short_str.substring(short_str.length() - mark_right);
            res = long_str + right_str;
        }
        return res;
    }

    public static void main(String[] args) {
        leetcode1092 l = new leetcode1092();
//        String s1 = "abac";
//        String s2 = "cab";
//        String s2 = "acb";
        String s1 = "bbbaaaba";
        String s2 = "bbababbb";
        String res = l.shortestCommonSupersequence(s1, s2);
        System.out.println(res);
    }
}
