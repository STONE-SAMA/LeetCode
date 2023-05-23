package mid;

public class leetcode1638 {
    /*
    统计只差一个字符的子串数目
    https://leetcode.cn/problems/count-substrings-that-differ-by-one-character/
     */
    public int countSubstrings(String s, String t) {
        int num = 0;
        int len = Math.min(s.length(), t.length());
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= s.length() - i; j++) {
                String sub_s = s.substring(j, j + i);
                for (int k = 0; k <= t.length() - i; k++) {
                    int mark = 0;
                    for (int x = 0; x < i; x++) {
                        if (sub_s.charAt(x) != t.charAt(x + k)) {
                            mark++;
                            if (mark >= 2) {
                                break;
                            }
                        }
                    }
                    if (mark == 1) {
                        num++;
                    }
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        leetcode1638 l = new leetcode1638();
        String s = "abe";
        String t = "bbc";
        int res = l.countSubstrings(s, t);
        System.out.println(res);
    }
}
