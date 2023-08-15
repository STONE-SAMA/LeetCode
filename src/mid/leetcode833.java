package mid;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode833 {
    /**
     * 字符串中的查找与替换
     * https://leetcode.cn/problems/find-and-replace-in-string/
     *
     * @param s
     * @param indices
     * @param sources
     * @param targets
     * @return
     */
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        for (int i = 0; i < indices.length - 1; i++) {
            for (int j = i + 1; j < indices.length; j++) {
                if (indices[i] > indices[j]) {
                    int temp = indices[i];
                    indices[i] = indices[j];
                    indices[j] = temp;
                    String temp_str = sources[i];
                    sources[i] = sources[j];
                    sources[j] = temp_str;
                    temp_str = targets[i];
                    targets[i] = targets[j];
                    targets[j] = temp_str;
                }
            }
        }

        Queue<String> queue = new LinkedList<>();
        int before = 0;
        for (int i = 0; i < indices.length; i++) {
            queue.add(s.substring(before, indices[i]));
            before = indices[i];
            int temp_len = sources[i].length();
            if (indices[i] + temp_len <= s.length()) {
                String temp_s = s.substring(indices[i], indices[i] + temp_len);
                if (temp_s.equals(sources[i])) {
                    queue.add(targets[i]);
                    before += temp_len;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.poll());
        }
        if (before < s.length()) {
            sb.append(s.substring(before));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        leetcode833 l = new leetcode833();
//        String s = "vmokgggqzp";
//        int[] indices = {3, 5, 1};
//        String[] sources = {"kg","ggq","mo"};
//        String[] targets = {"s","so","bfr"};
        String s = "abcde";
        int[] indices = {2, 2};
        String[] sources = {"cdef", "bc"};
        String[] targets = {"f", "fe"};
        String res = l.findReplaceString(s, indices, sources, targets);
        System.out.println(res);
    }
}
