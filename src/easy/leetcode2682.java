package easy;

import java.util.ArrayList;
import java.util.List;

public class leetcode2682 {
    /**
     * 找出转圈游戏输家
     * https://leetcode.cn/problems/find-the-losers-of-the-circular-game/
     *
     * @param n
     * @param k
     * @return
     */
    public int[] circularGameLosers(int n, int k) {
        int[] mark = new int[n];
        int base = 1;
        int temp = 0;
        mark[0] = 1;
        do {
            temp += base * k;
            temp %= n;
            mark[temp]++;
            base++;
        } while (mark[temp] != 2);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (mark[i] == 0) {
                list.add(i + 1);
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        leetcode2682 l = new leetcode2682();
        int[] ints = l.circularGameLosers(5, 2);
        for (int i : ints) {
            System.out.println(i);
        }
    }
}
