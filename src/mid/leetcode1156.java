package mid;

public class leetcode1156 {
    /**
     * 单字符重复子串的最大长度
     * https://leetcode.cn/problems/swap-for-longest-repeated-character-substring/
     *
     * @param text
     * @return
     */
    public int maxRepOpt1(String text) {
        int[] cnt = new int[26];
        int n = text.length();
        for (int i = 0; i < n; ++i) {
            ++cnt[text.charAt(i) - 'a'];
        }
        int ans = 0, i = 0;
        while (i < n) {
            int j = i;
            while (j < n && text.charAt(j) == text.charAt(i)) {
                ++j;
            }
            int l = j - i;
            int k = j + 1;
            while (k < n && text.charAt(k) == text.charAt(i)) {
                ++k;
            }
            int r = k - j - 1;
            ans = Math.max(ans, Math.min(l + r + 1, cnt[text.charAt(i) - 'a']));
            i = j;
        }
        return ans;
    }

    public static void main(String[] args) {
        leetcode1156 l = new leetcode1156();
        String str1 = "baaabaaaaaaabaab";
        String str2 = "bbababaaaa";
        String str3 = "aabaabaabbbaaabbbaabab";

        int res = l.maxRepOpt1(str3);
        System.out.println(res);
    }

    public int maxRepOpt1_old(String text) {
        int text_length = text.length();
        char temp = text.charAt(0);
        int len = 1;//相同字串的长度
        int index_start = 0;//最长相同字串的起始位置
        int index_end = 0;//最长相同字串的结束位置
        int max = 0;//最长字串长度
        int[] counts = new int[text_length];//得到字符串中各个连续字串的长度
        counts[0] = 1;
        int[] count_char = new int[26];//统计各个字符出现次数，确定能否通过移位来增加最长字串长度
        count_char[temp - 'a']++;
        for (int i = 1; i < text_length; i++) {
            count_char[text.charAt(i) - 'a']++;
            if (text.charAt(i) == temp) {
                len++;
            } else {
                if (len > max) {
                    max = len;
                    index_start = i - len;
                    index_end = i - 1;
                }
                temp = text.charAt(i);
                len = 1;
            }
            if (i == text_length - 1) {
                if (len > max) {
                    max = len;
                    index_start = i - len + 1;
                    index_end = i;
                }
            }
            counts[i] = len;
        }
        int left = max;
        int right = max;
        if (len == text_length) {
            return text_length;
        } else if (index_start == 0 && index_end == text_length - 2) {
            return text_length - 1;
        } else if (index_start == 1 && index_end == text_length - 1) {
            return text_length - 1;
        } else {
            //向前拓展
            if (index_start > 1) {
                if (text.charAt(index_start) != text.charAt(index_start - 2)) {
                    if (count_char[text.charAt(index_start) - 'a'] > max) {
                        left++;
                    }
                } else {
                    if (count_char[text.charAt(index_start) - 'a'] > (max + counts[index_start - 2])) {
                        left += counts[index_start - 2] + 1;
                    } else {
                        left += counts[index_start - 2];
                    }
                }
            }
            //向后拓展
            if (index_end < text_length - 2) {
                if (text.charAt(index_end) != text.charAt(index_end + 2)) {
                    if (count_char[text.charAt(index_end) - 'a'] > max) {
                        right++;
                    }
                } else {
                    int mark = 0;
                    for (int i = index_end + 2; i < text_length; i++) {
                        if (text.charAt(i) == text.charAt(index_end)) {
                            mark++;
                        } else {
                            break;
                        }
                    }
                    right += mark;
                    if (count_char[text.charAt(index_end) - 'a'] > max + mark) {
                        right++;
                    }
                }
            }
        }
        return Math.max(left, right);
    }
}
