package mid;

public class leetcode200 {
    /**
     * 岛屿数量
     * https://leetcode.cn/problems/number-of-islands/
     *
     * @param grid
     * @return
     */
    char[][] grid;
    int m;
    int n;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.m = grid.length;//行
        this.n = grid[0].length;//列
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(i, j);
                }
            }
        }

        return count;
    }

    private void dfs(int x, int y) {
        if (grid[x][y] == '1') {
            grid[x][y] = '0';
        } else {
            return;
        }
        //上
        if (y - 1 >= 0) {
            dfs(x, y - 1);
        }
        //下
        if (y + 1 < n) {
            dfs(x, y + 1);
        }
        //左
        if (x - 1 >= 0) {
            dfs(x - 1, y);
        }
        //右
        if (x + 1 < m) {
            dfs(x + 1, y);
        }
    }
}
