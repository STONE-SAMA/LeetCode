package mid;

public class leetcode289 {
    /**
     * 生命游戏
     * https://leetcode.cn/problems/game-of-life
     *
     * @param board
     */
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] copy_arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                copy_arr[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                if (i - 1 >= 0) {
                    if (j - 1 >= 0) {
                        count += copy_arr[i - 1][j - 1];
                    }
                    count += copy_arr[i - 1][j];
                    if (j + 1 < n) {
                        count += copy_arr[i - 1][j + 1];
                    }
                }
                if (j - 1 >= 0) {
                    count += copy_arr[i][j - 1];
                }
                if (j + 1 < n) {
                    count += copy_arr[i][j + 1];
                }
                if (i + 1 < m) {
                    if (j - 1 >= 0) {
                        count += copy_arr[i + 1][j - 1];
                    }
                    count += copy_arr[i + 1][j];
                    if (j + 1 < n) {
                        count += copy_arr[i + 1][j + 1];
                    }
                }
                if (copy_arr[i][j] == 0) {
                    if (count == 3) {
                        board[i][j] = 1;
                    } else {
                        board[i][j] = 0;
                    }
                } else {
                    if (count == 2 || count == 3) {
                        board[i][j] = 1;
                    } else {
                        board[i][j] = 0;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        leetcode289 l = new leetcode289();
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        l.gameOfLife(board);

    }
}
