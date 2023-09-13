package mid;

public class leetcode2596 {
    /**
     * @param grid
     * @return
     */
    int len;
    int[][] mark;

    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) {
            return false;
        }
        len = grid.length;
        mark = new int[len][len];
        int temp = 0;
        int x = 0;
        int y = 0;
        while (temp + 1 < len * len) {
            temp++;
            int[] arr = cal(grid, x, y, temp);
            x = arr[0];
            y = arr[1];
            if (x == 0 && y == 0) {
                return false;
            }
        }
        return true;
    }

    private int[] cal(int[][] grid, int x, int y, int target) {
        int[] res = new int[2];
        if (x - 2 >= 0) {
            if (y - 1 >= 0) {
                if (grid[x - 2][y - 1] == target) {
                    if (mark[x - 2][y - 1] != 1) {
                        mark[x - 2][y - 1] = 1;
                        res[0] = x - 2;
                        res[1] = y - 1;
                    }
                    return res;
                }
            }
            if (y + 1 < len) {
                if (grid[x - 2][y + 1] == target) {
                    if (mark[x - 2][y + 1] != 1) {
                        mark[x - 2][y + 1] = 1;
                        res[0] = x - 2;
                        res[1] = y + 1;
                    }
                    return res;
                }
            }
        }
        if (x - 1 >= 0) {
            if (y - 2 >= 0) {
                if (grid[x - 1][y - 2] == target) {
                    if (mark[x - 1][y - 2] != 1) {
                        mark[x - 1][y - 2] = 1;
                        res[0] = x - 1;
                        res[1] = y - 2;
                    }
                    return res;
                }
            }
            if (y + 2 < len) {
                if (grid[x - 1][y + 2] == target) {
                    if (mark[x - 1][y + 2] != 1) {
                        mark[x - 1][y + 2] = 1;
                        res[0] = x - 1;
                        res[1] = y + 2;
                    }
                    return res;
                }
            }
        }
        if (x + 1 < len) {
            if (y - 2 >= 0) {
                if (grid[x + 1][y - 2] == target) {
                    if (mark[x + 1][y - 2] != 1) {
                        mark[x + 1][y - 2] = 1;
                        res[0] = x + 1;
                        res[1] = y - 2;
                    }
                    return res;
                }
            }
            if (y + 2 < len) {
                if (grid[x + 1][y + 2] == target) {
                    if (mark[x + 1][y + 2] != 1) {
                        mark[x + 1][y + 2] = 1;
                        res[0] = x + 1;
                        res[1] = y + 2;
                    }
                    return res;
                }
            }
        }
        if (x + 2 < len) {
            if (y - 1 >= 0) {
                if (grid[x + 2][y - 1] == target) {
                    if (mark[x + 2][y - 1] != 1) {
                        mark[x + 2][y - 1] = 1;
                        res[0] = x + 2;
                        res[1] = y - 1;
                    }
                    return res;
                }
            }
            if (y + 1 < len) {
                if (grid[x + 2][y + 1] == target) {
                    if (mark[x + 2][y + 1] != 1) {
                        mark[x + 2][y + 1] = 1;
                        res[0] = x + 2;
                        res[1] = y + 1;
                    }
                    return res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        leetcode2596 l = new leetcode2596();
        int[][] num = {{0, 11, 16, 5, 20}, {17, 4, 19, 10, 15}, {12, 1, 8, 21, 6}, {3, 18, 23, 14, 9}, {24, 13, 2, 7, 22}};
        boolean b = l.checkValidGrid(num);
        System.out.println(b);

    }


}
