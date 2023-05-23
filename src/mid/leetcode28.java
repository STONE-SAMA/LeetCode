package mid;

public class leetcode28 {
    /*
    找出字符串中第一个匹配项的下标
    https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/
     */
    public int strStr(String haystack, String needle) {
        int index = -1;
        int i = 0;
        if (haystack.length() < needle.length()) {
            return -1;
        }
        while (i <= haystack.length() - needle.length()) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                boolean flag = true;
                int temp = i;
                for (int j = 1; j < needle.length(); j++) {
                    if (needle.charAt(j) != haystack.charAt(i + j)) {
                        flag = false;
                        i++;
                        break;
                    }
                }
                if (flag) {
                    index = temp;
                    return index;
                }
            } else {
                i++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        String s1 = "mississippi";
        String s2 = "issipi";
        leetcode28 l = new leetcode28();
        int res = l.strStr(s1, s2);
        System.out.println(res);
    }
}
