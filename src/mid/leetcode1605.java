package mid;

public class leetcode1605 {
    /*
    给定行和列的和求可行矩阵
    https://leetcode.cn/problems/find-valid-matrix-given-row-and-column-sums/
     */
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int row = rowSum.length;
        int col = colSum.length;
        int[][] res = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= res[i][j];
                colSum[j] -= res[i][j];
            }
        }

        return res;
    }
}
