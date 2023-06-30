package easy;

public class leetcode2490 {
    /**
     * 回环句
     * https://leetcode.cn/problems/circular-sentence/
     *
     * @param sentence
     * @return
     */
    public boolean isCircularSentence(String sentence) {
        String[] strs = sentence.split(" ");
        if (strs.length == 1) {
            return strs[0].charAt(0) == strs[0].charAt(strs[0].length() - 1);
        }
        if (strs[0].charAt(0) != strs[strs.length - 1].charAt(strs[strs.length - 1].length() - 1)) {
            return false;
        }
        for (int i = 0; i < strs.length - 1; i++) {
            if (strs[i].charAt(strs[i].length() - 1) != strs[i + 1].charAt(0)) {
                return false;
            }
        }
        return true;
    }
}
