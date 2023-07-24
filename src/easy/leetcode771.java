package easy;

import java.util.HashSet;
import java.util.Set;

public class leetcode771 {

    /**
     * 宝石与石头
     * https://leetcode.cn/problems/jewels-and-stones/
     *
     * @param jewels
     * @param stones
     * @return
     */
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> jSet = new HashSet<>();
        for (int i = 0; i < jewels.length(); i++) {
            jSet.add(jewels.charAt(i));
        }
        int res = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (jSet.contains(stones.charAt(i))) {
                res++;
            }
        }
        return res;
    }
}
