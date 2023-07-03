package easy;

public class leetcode392 {
    /**
     * 判断子序列
     * https://leetcode.cn/problems/is-subsequence
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        if (s.length()>t.length()){
            return false;
        }
        if (s.length()==0){
            return true;
        }
        int s1 = 0;
        int t1 = 0;
        while (s1 < s.length()) {
            while (t.charAt(t1) != s.charAt(s1)) {
                t1++;
                if (t1 >= t.length()) {
                    return false;
                }
            }
            t1++;
            if (t1 >= t.length()) {
                return false;
            }
            s1++;
        }
        return true;
    }

    public static void main(String[] args) {
        leetcode392 l = new leetcode392();
        String s = "acb";
        String t = "ahbgdc";
        boolean res = l.isSubsequence(s, t);
        System.out.println(res);
    }
}
