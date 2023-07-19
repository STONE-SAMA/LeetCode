package mid;

import java.util.Arrays;

public class leetcode73 {
    /**
     * 矩阵置零
     * https://leetcode.cn/problems/set-matrix-zeroes
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int raw = matrix.length;
        int col = matrix[0].length;
        int[][] copy_arr = new int[raw][];
        for (int i = 0; i < raw; i++) {
            int[] temp = matrix[i];
            copy_arr[i] = new int[temp.length];
            System.arraycopy(temp, 0, copy_arr[i], 0, temp.length);
        }
        for (int i = 0; i < raw; i++) {
            for (int j = 0; j < col; j++) {
                if (copy_arr[i][j] == 0) {
                    for (int x = 0; x < raw; x++) {
                        matrix[x][j] = 0;
                    }
                    for (int y = 0; y < col; y++) {
                        matrix[i][y] = 0;
                    }
                }
            }
        }

    }
}
