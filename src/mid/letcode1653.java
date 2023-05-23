package mid;

public class letcode1653 {
    /*
    使字符串平衡的最少删除次数
    https://leetcode.cn/problems/minimum-deletions-to-make-string-balanced/
     */
    public int minimumDeletions(String s) {
        int count_a = 0, count_b = 0;
        //统计a/b的数量
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                count_a++;
            } else {
                count_b++;
            }
        }
        //前删b,后删a：即统计当前位置前b后a的数量
        int res = Math.min(count_a, count_b);
        int mark_a = count_a;//当前位置后面a的数量
        int mark_b = 0;//当前位置前面b的数量
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                mark_a--;
            } else {
                mark_b++;
            }
            res = Math.min(res, mark_a + mark_b);
        }
        return res;
    }
}
