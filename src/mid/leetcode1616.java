package mid;

public class leetcode1616 {
    /*
    分割两个字符串得到回文串
    https://leetcode.cn/problems/split-two-strings-to-make-palindrome/
     */

    public boolean checkPalindromeFormation(String a, String b) {
        return check(a, b) || check(b, a);
    }

    // 如果 a_prefix + b_suffix 可以构成回文串则返回 true，否则返回 false
    private boolean check(String a, String b) {
        int i = 0, j = a.length() - 1; // 相向双指针
        while (i < j && a.charAt(i) == b.charAt(j)) { // 前后缀尽量匹配
            ++i;
            --j;
        }
        return isPalindrome(a, i, j) || isPalindrome(b, i, j);
    }

    // 如果从 s[i] 到 s[j] 是回文串则返回 true，否则返回 false
    private boolean isPalindrome(String s, int i, int j) {
        while (i < j && s.charAt(i) == s.charAt(j)) {
            ++i;
            --j;
        }
        return i >= j;
    }


    public static void main(String[] args) {
        leetcode1616 l = new leetcode1616();
        String a = "babbaa";
        String b = "accddb";
        boolean res = l.checkPalindromeFormation(a, b);
        System.out.println(res);

    }




    public boolean checkPalindromeFormation_OutOfTime(String a, String b) {
        if (checkString(a) || checkString(b)) {
            return true;
        }
        int len = a.length();
        for (int i = 1; i < len - 1; i++) {
            StringBuilder str1 = new StringBuilder(a.substring(0, i));
            str1.append(b.substring(i, len));
            if (checkString(String.valueOf(str1))) {
                return true;
            }
            StringBuilder str2 = new StringBuilder(b.substring(0, i));
            str2.append(a.substring(i, len));
            if (checkString(String.valueOf(str2))) {
                return true;
            }
        }
        return false;
    }

    //检查是否是回文字符串
    private boolean checkString(String str) {
        boolean res = true;
        int len = str.length();
        if (len % 2 == 0) {
            int right = len / 2;
            int left = right - 1;
            if (str.charAt(left) == str.charAt(right)) {
                int i = 1;
                while (right + i < len) {
                    if (str.charAt(right + i) != str.charAt(left - i)) {
                        res = false;
                        break;
                    }
                    i++;
                }
            } else {
                res = false;
            }
        } else {
            int mid = len / 2;
            for (int i = 0; i < mid; i++) {
                if (str.charAt(i) != str.charAt(len - 1 - i)) {
                    res = false;
                    break;
                }
            }
        }
        return res;
    }
}
