package easy;

public class leetcode1572 {
    /**
     * 矩阵对角线元素的和
     * https://leetcode.cn/problems/matrix-diagonal-sum/
     *
     * @param mat
     * @return
     */
    public int diagonalSum(int[][] mat) {
        if (mat.length == 1) {
            return mat[0][0];
        }
        int len = mat.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += mat[i][i];
            mat[i][i] = 0;
            sum += mat[i][len - i - 1];
        }
        return sum;
    }
}
