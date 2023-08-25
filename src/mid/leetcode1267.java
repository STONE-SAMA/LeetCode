package mid;

public class leetcode1267 {
    /**
     * 统计参与通信的服务器
     * https://leetcode.cn/problems/count-servers-that-communicate
     *
     * @param grid
     * @return
     */
    public int countServers(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] != 0) {
                    boolean flag = false;
                    for (int x = i + 1; x < row; x++) {
                        if (grid[x][j] == 1) {
                            res++;
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        for (int x = i - 1; x >= 0; x--) {
                            if (grid[x][j] == 1) {
                                res++;
                                flag = true;
                                break;
                            }
                        }
                    }
                    if (!flag) {
                        for (int y = j + 1; y < col; y++) {
                            if (grid[i][y] == 1) {
                                res++;
                                flag = true;
                                break;
                            }
                        }
                    }
                    if (!flag) {
                        for (int y = j - 1; y >= 0; y--) {
                            if (grid[i][y] == 1) {
                                res++;
                                flag = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

}
