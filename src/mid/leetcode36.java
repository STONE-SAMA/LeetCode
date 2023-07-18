package mid;

import java.util.HashSet;
import java.util.Set;

public class leetcode36 {
    /**
     * 有效的数独
     * https://leetcode.cn/problems/valid-sudoku
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        Set<Integer> set;
        //行
        for (int i = 0; i < 9; i++) {
            set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!set.contains(board[i][j] - '0')) {
                        set.add(board[i][j] - '0');
                    } else {
                        return false;
                    }
                }
            }
        }
        //列
        for (int i = 0; i < 9; i++) {
            set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    if (!set.contains(board[j][i] - '0')) {
                        set.add(board[j][i] - '0');
                    } else {
                        return false;
                    }
                }
            }
        }
        //块
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                set = new HashSet<>();
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        if (board[i + x][j + y] != '.') {
                            if (!set.contains(board[i + x][j + y] - '0')) {
                                set.add(board[i + x][j + y] - '0');
                            } else {
                                return false;
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
}
