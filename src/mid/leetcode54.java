package mid;

import java.util.ArrayList;
import java.util.List;

public class leetcode54 {
    /**
     * 螺旋矩阵
     * https://leetcode.cn/problems/spiral-matrix
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 1) {
            if (matrix[0].length == 1) {
                list.add(matrix[0][0]);
            } else {
                for (int i = 0; i < matrix[0].length; i++) {
                    list.add(matrix[0][i]);
                }
            }
            return list;
        }
        if (matrix[0].length == 1) {
            for (int i = 0; i < matrix.length; i++) {
                list.add(matrix[i][0]);
            }
            return list;
        }
        int i = 0;//方向标志
        int x = 0, y = 0;//当前坐标
        while (list.size() != matrix.length * matrix[0].length) {
            if (i % 4 == 0) {//行右
                if (matrix[x][y] != Integer.MAX_VALUE) {
                    list.add(matrix[x][y]);
                    matrix[x][y] = Integer.MAX_VALUE;
                }
                while (y + 1 < matrix[0].length && matrix[x][y + 1] != Integer.MAX_VALUE) {
                    y++;
                    list.add(matrix[x][y]);
                    matrix[x][y] = Integer.MAX_VALUE;
                }
            } else if (i % 4 == 1) {//列下
                while (x + 1 < matrix.length && matrix[x + 1][y] != Integer.MAX_VALUE) {
                    x++;
                    list.add(matrix[x][y]);
                    matrix[x][y] = Integer.MAX_VALUE;
                }
            } else if (i % 4 == 2) {//行左
                while (y - 1 >= 0 && matrix[x][y - 1] != Integer.MAX_VALUE) {
                    y--;
                    list.add(matrix[x][y]);
                    matrix[x][y] = Integer.MAX_VALUE;
                }
            } else {//列上
                while (x - 1 > 0 && matrix[x - 1][y] != Integer.MAX_VALUE) {
                    x--;
                    list.add(matrix[x][y]);
                    matrix[x][y] = Integer.MAX_VALUE;
                }
            }
            i++;
        }
        return list;
    }
}
