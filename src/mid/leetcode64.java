package mid;

public class leetcode64 {
    /**
     * 最小路径和
     * https://leetcode.cn/problems/minimum-path-sum
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (m == 1 && n == 1) {
            return grid[0][0];
        }
        int[][] mark = new int[m][n];
        mark[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {//第一行只能向右走，路径计算
            mark[0][i] = mark[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {//第一列只能向下走，路径计算
            mark[i][0] = mark[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int min = Math.min(mark[i - 1][j], mark[i][j - 1]);
                mark[i][j] = min + grid[i][j];
            }
        }
        return mark[m - 1][n - 1];
    }
}
