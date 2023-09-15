package mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int stage = triangle.size();
        if (stage == 1) {
            return triangle.get(0).get(0);
        }
        int[][] dp = new int[stage][stage];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < stage; i++) {
            for (int j = 0; j <= i; j++) {
                int left = Integer.MAX_VALUE;
//                int right = dp[i - 1][j] == 0 ? Integer.MAX_VALUE : dp[i - 1][j];
                int right = Integer.MAX_VALUE;
                if (j < triangle.get(i-1).size()) {
                    right = dp[i - 1][j];
                }
                if (j - 1 >= 0) {
                    left = dp[i - 1][j - 1];
                }
                dp[i][j] = triangle.get(i).get(j) + Math.min(left, right);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < stage; i++) {
            min = Math.min(min, dp[stage - 1][i]);
        }
        return min;
    }

    public static void main(String[] args) {
        leetcode120 l = new leetcode120();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        int res = l.minimumTotal(triangle);
        System.out.println(res);
    }
}
