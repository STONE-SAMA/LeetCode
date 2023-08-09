package mid;

import java.util.HashSet;
import java.util.Set;

public class leetcode822 {
    /**
     * 翻转卡片游戏
     * https://leetcode.cn/problems/card-flipping-game/description/
     *
     * @param fronts
     * @param backs
     * @return
     */
    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                set.add(fronts[i]);
            }
        }
        int front = Integer.MAX_VALUE;
        for (int x : fronts) {
            if (!set.contains(x)) {
                front = Math.min(front, x);
            }
        }
        int back = Integer.MAX_VALUE;
        for (int y : backs) {
            if (!set.contains(y)) {
                back = Math.min(back, y);
            }
        }
        return Math.min(front, back) != Integer.MAX_VALUE ? Math.min(front, back) : 0;
    }
}
