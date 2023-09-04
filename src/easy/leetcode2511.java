package easy;

import java.util.ArrayList;
import java.util.List;

public class leetcode2511 {
    /**
     * 最多可以摧毁的敌人城堡数目
     * https://leetcode.cn/problems/maximum-enemy-forts-that-can-be-captured
     *
     * @param forts
     * @return
     */
    public int captureForts(int[] forts) {
        int res = 0;
        int len = forts.length;
        int i = 0;
        while (i < len) {
            int j = i + 1;
            if (forts[i] != 0) {
                while (j < len && forts[j] == 0) {
                    j++;
                }
                if (j < len && forts[i] + forts[j] == 0) {
                    res = Math.max(res, j - i - 1);
                }
            }
            i = j;
        }
        return res;
    }
}
