package mid;

public class leetcode63 {
    /**
     * 不同路径 II
     * https://leetcode.cn/problems/unique-paths-ii/
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1)
            return 0;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (m == 1 && n == 1) {
            if (obstacleGrid[0][0] != 1) {
                return 1;
            } else {
                return 0;
            }
        }

        int[][] mark = new int[m][n];
        mark[0][0] = 1;
        for (int i = 1; i < n; i++) {//第一行只能向右走，路径计算
            if (obstacleGrid[0][i] == 1) {
                mark[0][i] = 0;
            } else {
                mark[0][i] = mark[0][i - 1];
            }
        }
        for (int i = 1; i < m; i++) {//第一列只能向下走，路径计算
            if (obstacleGrid[i][0] == 1) {
                mark[i][0] = 0;
            } else {
                mark[i][0] = mark[i - 1][0];
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    mark[i][j] = 0;
                } else {
                    mark[i][j] = mark[i - 1][j] + mark[i][j - 1];
                }
            }
        }
        return mark[m - 1][n - 1];
    }
}
