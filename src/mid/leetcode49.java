package mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class leetcode49 {
    /**
     * 字母异位词分组
     * https://leetcode.cn/problems/group-anagrams/
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            List<String> list;
            if (!map.containsKey(new String(c))) {
                list = new ArrayList<>();
            } else {
                list = map.get(new String(c));
            }
            list.add(strs[i]);
            map.put(new String(c), list);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        leetcode49 l = new leetcode49();
        String[] strings = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> lists = l.groupAnagrams(strings);
        System.out.println(lists);
    }
}
