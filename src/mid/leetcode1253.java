package mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode1253 {
    /**
     * 重构 2 行二进制矩阵
     * https://leetcode.cn/problems/reconstruct-a-2-row-binary-matrix/
     *
     * @param upper
     * @param lower
     * @param colsum
     * @return
     */
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int[] up = new int[colsum.length];
        int[] down = new int[colsum.length];
        int sum_up = 0;
        int sum_down = 0;
        List<Integer> list_index = new ArrayList<>();//存储和为1的列的下标
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 2) {
                up[i] = 1;
                down[i] = 1;
                sum_up++;
                sum_down++;
            } else if (colsum[i] == 1) {
                list_index.add(i);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        if (sum_up>upper){
            return res;
        }
        for (int index : list_index) {
            if (sum_up < upper) {//当上面行的和小于upper时，优先上面行填1
                up[index] = 1;
                sum_up++;
            } else {
                down[index] = 1;//上面行已等于upper时，下面行填1
                sum_down++;
            }
        }
        if (sum_down==lower){
            res.add(Arrays.asList(Arrays.stream(up).boxed().toArray(Integer[]::new)));
            res.add(Arrays.asList(Arrays.stream(down).boxed().toArray(Integer[]::new)));
        }
        return res;
    }
}
