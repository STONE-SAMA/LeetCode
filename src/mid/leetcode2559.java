package mid;

import java.util.ArrayList;
import java.util.List;

public class leetcode2559 {
    /**
     * 统计范围内的元音字符串数
     * https://leetcode.cn/problems/count-vowel-strings-in-ranges/
     *
     * @param words
     * @param queries
     * @return
     */
    public int[] vowelStrings(String[] words, int[][] queries) {
        List<Character> arr = new ArrayList<>();
        arr.add('a');
        arr.add('e');
        arr.add('i');
        arr.add('o');
        arr.add('u');
        int[] count = new int[words.length + 1];//前缀和
        for (int i = 0; i < words.length; i++) {
            char start = words[i].charAt(0);
            char end = words[i].charAt(words[i].length() - 1);
            if (arr.contains(start) && arr.contains(end)) {
                count[i + 1] = count[i] + 1;
            } else {
                count[i + 1] = count[i];
            }
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start_idx = queries[i][0];
            int end_idx = queries[i][1];
            int temp = count[end_idx + 1] - count[start_idx];
            ans[i] = temp;
        }

        return ans;
    }

    public static void main(String[] args) {
        leetcode2559 l = new leetcode2559();
        String[] words = {"aba","bcb","ece","aa","e"};
        int[][] queries = {{0,2},{1,4},{1,1}};
        int[] res = l.vowelStrings(words,queries);
        for (int i:res){
            System.out.print(i + " ");
        }

    }
}
