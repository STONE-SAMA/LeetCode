package mid;

public class leetcode831 {
    /*
    隐藏个人信息
    https://leetcode.cn/problems/masking-personal-information/
     */
    public String maskPII(String s) {
        char c = s.charAt(0);
        String res;
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            //邮箱
            int index = 0;
            while (s.charAt(index) != '@') {
                index++;
            }
            String str_name = s.substring(0, index).toLowerCase();
            String com = s.substring(index + 1).toLowerCase();
            res = str_name.charAt(0) + "*****" + str_name.charAt(str_name.length() - 1) + "@" + com;
        } else {
            //电话
            String num = "";
            for (int i = 0; i < s.length(); i++) {
                char temp = s.charAt(i);
                if (temp >= '0' && temp <= '9') {
                    num += temp;
                }
            }
            int len = num.length();
            String str_num = "";
            if (len == 11) {
                str_num = "+*-";
            } else if (len == 12) {
                str_num = "+**-";
            } else if (len == 13) {
                str_num = "+***-";
            }
            res = str_num + "***-***-" + num.substring(len - 4);
        }
        return res;
    }

    public static void main(String[] args) {
        leetcode831 l = new leetcode831();
        String str = "AB@qq.com";
        String res = l.maskPII(str);
        System.out.println(res);
    }
}
