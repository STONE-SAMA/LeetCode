package mid;

import java.util.HashSet;
import java.util.Set;

public class leetcode1654 {
    /**
     * 到家的最少跳跃次数
     * https://leetcode.cn/problems/minimum-jumps-to-reach-home/
     *
     * @param forbidden
     * @param a
     * @param b
     * @param x
     * @return
     */
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> set = new HashSet<>();
        for (int data : forbidden) {
            set.add(data);
        }
        int step = a - b;
        int res = -1;


        return res;
    }
}
