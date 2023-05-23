package offer;

public class offer47 {
    /*
    剑指 Offer 47. 礼物的最大价值
    https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/
     */
    public int maxValue(int[][] grid) {
        //动态规划
        int raw = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < raw; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0)
                    continue;
                if (i == 0) {//第一行
                    grid[i][j] += grid[i][j - 1];
                } else if (j == 0) {//第一列
                    grid[i][j] += grid[i - 1][j];
                } else {
                    grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
                }
            }
        }
        return grid[raw - 1][col - 1];
    }
}
