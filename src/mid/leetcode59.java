package mid;

public class leetcode59 {

    /**
     * 螺旋矩阵 II
     * https://leetcode.cn/problems/spiral-matrix-ii/
     *
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int count = 1;
        int flag = 0;
        int len = n;
        int[][] res = new int[n][n];
        int x = 0;
        int y = 0;
        while (count <= n * n) {
            if (flag % 4 == 0) {
                //向右
                int i = 0;
                for (; i < len; i++) {
                    res[x][y + i] = count;
                    count++;
                }
                y = y + i - 1;
                len--;
            } else if (flag % 4 == 1) {
                //向下
                int i = 1;
                for (; i <= len; i++) {
                    res[x + i][y] = count;
                    count++;
                }
                x += i - 1;
            } else if (flag % 4 == 2) {
                //向左
                int i = 1;
                for (; i <= len; i++) {
                    res[x][y - i] = count;
                    count++;
                }
                len--;
                y = y - i + 1;
            } else {
                //向上
                int i = 1;
                for (; i <= len; i++) {
                    res[x - i][y] = count;
                    count++;
                }
                x = x - i + 1;
                y++;
            }
            flag++;
        }
        return res;
    }

    public static void main(String[] args) {
//        String s1 = new String("abc");
//        String s2 = new String("abc");
//        System.out.println(s1==s2);
//        System.out.println(s1.equals(s2));

        leetcode59 l = new leetcode59();
        int[][] res = l.generateMatrix(4);
        for (int[] nums : res) {
            for (int num : nums) {
                System.out.printf(num + " ");
            }
            System.out.println();
        }
    }
}
