package mid;

public class leetcode931 {
    /**
     * 下降路径最小和
     * https://leetcode.cn/problems/minimum-falling-path-sum/
     *
     * @param matrix
     * @return
     */
    public int minFallingPathSum(int[][] matrix) {
        int res = 0;
        if (matrix[0].length == 1) {
            for (int i = 0; i < matrix.length; i++) {
                res += matrix[i][0];
            }
            return res;
        }

        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            dp[0][i] = matrix[0][i];
        }
        for (int i = 1; i < matrix.length; i++) {
            dp[i][0] = Math.min(dp[i - 1][0] + matrix[i][0], dp[i - 1][1] + matrix[i][0]);
            for (int j = 1; j < matrix[0].length - 1; j++) {
                int min = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                min = Math.min(min, dp[i - 1][j + 1]);
                dp[i][j] = min + matrix[i][j];
            }
            dp[i][matrix[0].length - 1] = Math.min(dp[i - 1][matrix[0].length - 1] + matrix[i][matrix[0].length - 1], dp[i - 1][matrix[0].length - 2] + matrix[i][matrix[0].length - 1]);
        }
        res = dp[dp.length - 1][0];
        for (int i = 1; i < dp[0].length; i++) {
            res = Math.min(res, dp[dp.length - 1][i]);
        }
        return res;
    }
}
