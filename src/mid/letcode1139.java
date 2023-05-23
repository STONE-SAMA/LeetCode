package mid;

public class letcode1139 {
    /*
    最大的以 1 为边界的正方形
    https://leetcode.cn/problems/largest-1-bordered-square/
     */
    public int largest1BorderedSquare(int[][] grid) {
        int raw = grid.length;
        int col = grid[0].length;
        int index = Math.min(raw, col);
        while (index > 0) {
            for (int i = 0; i <= raw - index; i++) {
                for (int j = 0; j <= col - index; j++) {
                    // (i,j)为正方形左上角
                    boolean flag = true;
                    for (int d = 0; d < index; d++) {
                        if (grid[i + d][j] != 1 || grid[i][j + d] != 1) {
                            flag = false;
                            break;
                        }
                        if (grid[i + d][j + index - 1] != 1 || grid[i + index - 1][j + d] != 1) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        return index * index;
                    }
                }
            }
            index--;
        }
        return 0;
    }

    public static void main(String[] args) {
        letcode1139 l = new letcode1139();
        int[][] arr = {{1, 1}, {1, 1}};
        int res = l.largest1BorderedSquare(arr);
        System.out.println(res);
    }
}
