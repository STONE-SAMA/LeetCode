package mid;

import java.util.Arrays;
import java.util.Comparator;

public class leetcode1626 {
    /*
    无矛盾的最佳球队
    https://leetcode.cn/problems/best-team-with-no-conflicts/
     */
    public int bestTeamScore(int[] scores, int[] ages) {
        int[][] array = new int[scores.length][2];
        for (int i = 0; i < scores.length; i++) {
            array[i][0] = scores[i];
            array[i][1] = ages[i];
        }
//        Arrays.sort(array, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o2[0]==o1[0]){
                    return o1[1] - o2[1];
                }else {
                    return o1[0] - o2[0];
                }
            }
        });
        int res = 0;
        int[] dp = new int[scores.length];
        for (int i = 0; i < scores.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (array[j][1] <= array[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += array[i][0];
            res = Math.max(dp[i], res);
        }
        return res;
    }

    public static void main(String[] args) {
        leetcode1626 l = new leetcode1626();
//        int[] scores = {1, 3, 5, 10, 15};
//        int[] ages = {1, 2, 3, 4, 5};
        int[] scores = {1, 1, 1, 1, 1};
        int[] ages = {811, 364, 124, 873, 656};
        l.bestTeamScore(scores, ages);
    }
}
