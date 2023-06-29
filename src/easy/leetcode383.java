package easy;

import java.util.HashMap;

public class leetcode383 {
    /**
     * 赎金信
     * https://leetcode.cn/problems/ransom-note
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char temp = magazine.charAt(i);
            if (!map.containsKey(temp)) {
                map.put(temp, 1);
            } else {
                map.put(temp, map.get(temp) + 1);
            }
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char temp = ransomNote.charAt(i);
            if (!map.containsKey(temp)) {
                return false;
            } else {
                if (map.get(temp) < 1) {
                    return false;
                } else {
                    map.put(temp, map.get(temp) - 1);
                }
            }
        }
        return true;
    }
}
