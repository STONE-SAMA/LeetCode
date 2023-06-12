package mid;

import java.util.Arrays;

public class leetcode1170 {
    /**
     * 比较字符串最小字母出现频次
     * https://leetcode.cn/problems/compare-strings-by-frequency-of-the-smallest-character/
     *
     * @param queries
     * @param words
     * @return
     */
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        //先对words进行计算，得到words中每个成员的相应f(word)值，再将queries中的每个元素与其比较
        int[] count = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            count[i] = calculateF(words[i]);
        }
        Arrays.sort(count);
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int temp = calculateF(queries[i]);
            res[i] = countNum(temp, count);
        }
        return res;
    }

    /**
     * 计算字符串中字典序最小字母出现次数
     * @param str
     * @return
     */
    private int calculateF(String str) {
        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++) {
            int temp = str.charAt(i) - 'a';
            count[temp]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i]!=0){
                return count[i];
            }
        }
        return 0;
    }

    private int countNum(int a, int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (a < arr[i]) {
                count++;
            }
        }
        return count;
    }

}
