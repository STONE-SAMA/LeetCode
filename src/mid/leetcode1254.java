package mid;

public class leetcode1254 {
    /**
     * 统计封闭岛屿的数目
     * https://leetcode.cn/problems/number-of-closed-islands/
     *
     * @param grid
     * @return
     */
    int[][] grid;

    public int closedIsland(int[][] grid) {
        this.grid = grid;
        int raw = grid.length;
        int col = grid[0].length;
        int count = 0;
        for (int i = 0; i < raw; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    if (dfs(i, j, raw, col)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean dfs(int i, int j, int raw, int col) {
        if (i < 0 || j < 0 || i >= raw || j >= col) {
            return false;
        }
        if (grid[i][j] == 0) {
            grid[i][j] = 1;
            boolean up = dfs(i, j - 1, raw, col);
            boolean down = dfs(i, j + 1, raw, col);
            boolean left = dfs(i - 1, j, raw, col);
            boolean right = dfs(i + 1, j, raw, col);
            return (up && down && left && right);
        }
        return true;
    }
}
