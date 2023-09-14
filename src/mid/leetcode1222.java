package mid;

import java.util.ArrayList;
import java.util.List;

public class leetcode1222 {
    /**
     * 可以攻击国王的皇后
     * https://leetcode.cn/problems/queens-that-can-attack-the-king
     *
     * @param queens
     * @param king
     * @return
     */
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int[][] mark = new int[8][8];
        for (int[] arr : queens) {
            mark[arr[0]][arr[1]] = 1;
        }
        int x = king[0];
        int y = king[1];
        List<List<Integer>> res = new ArrayList<>();
        for (int i = y - 1; i >= 0; i--) {//向左
            if (x < 0 || x >= 8 || y < 0 || y >= 8) {
                break;
            }
            if (mark[x][i] == 1) {
                List<Integer> temp = new ArrayList<>();
                temp.add(x);
                temp.add(i);
                res.add(temp);
                break;
            }
        }
        for (int i = y + 1; i < 8; i++) {//向右
            if (x < 0 || x >= 8 || y < 0 || y >= 8) {
                break;
            }
            if (mark[x][i] == 1) {
                List<Integer> temp = new ArrayList<>();
                temp.add(x);
                temp.add(i);
                res.add(temp);
                break;
            }
        }
        for (int i = x - 1; i >= 0; i--) {//向上
            if (x < 0 || x >= 8 || y < 0 || y >= 8) {
                break;
            }
            if (mark[i][y] == 1) {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(y);
                res.add(temp);
                break;
            }
        }
        for (int i = x + 1; i < 8; i++) {//向下
            if (x < 0 || x >= 8 || y < 0 || y >= 8) {
                break;
            }
            if (mark[i][y] == 1) {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(y);
                res.add(temp);
                break;
            }
        }
        for (int i = 1; i < 8; i++) {//向左上
            if (x - i < 0 || x - i >= 8 || y - i < 0 || y - i >= 8) {
                break;
            }
            if (mark[x - i][y - i] == 1) {
                List<Integer> temp = new ArrayList<>();
                temp.add(x - i);
                temp.add(y - i);
                res.add(temp);
                break;
            }
        }
        for (int i = 1; i < 8; i++) {//向左下
            if (x - i < 0 || x - i >= 8 || y + i < 0 || y + i >= 8) {
                break;
            }
            if (mark[x - i][y + i] == 1) {
                List<Integer> temp = new ArrayList<>();
                temp.add(x - i);
                temp.add(y + i);
                res.add(temp);
                break;
            }
        }
        for (int i = 1; i < 8; i++) {//向右上
            if (x + i < 0 || x + i >= 8 || y - i < 0 || y - i >= 8) {
                break;
            }
            if (mark[x + i][y - i] == 1) {
                List<Integer> temp = new ArrayList<>();
                temp.add(x + i);
                temp.add(y - i);
                res.add(temp);
                break;
            }
        }
        for (int i = 1; i < 8; i++) {//向右下
            if (x + i < 0 || x + i >= 8 || y + i < 0 || y + i >= 8) {
                break;
            }
            if (mark[x + i][y + i] == 1) {
                List<Integer> temp = new ArrayList<>();
                temp.add(x + i);
                temp.add(y + i);
                res.add(temp);
                break;
            }
        }
        return res;
    }
}
