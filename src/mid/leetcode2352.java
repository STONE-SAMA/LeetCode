package mid;

public class leetcode2352 {
    /**
     * 相等行列对
     * https://leetcode.cn/problems/equal-row-and-column-pairs/
     *
     * @param grid
     * @return
     */
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int[][] reverse_grid = new int[n][n];//转置原矩阵
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                reverse_grid[j][i] = grid[i][j];
            }
        }
        int count = 0;

        for (int i=0;i<n;i++){
            count += isEqual(grid[i], reverse_grid);
        }
        return count;
    }

    private int isEqual(int[] arr, int[][] rev){
        int num = arr.length;
        int mark = 0;

        for (int i=0;i<num;i++){
            for (int j=0;j<num;j++){
                if (rev[i][j]!=arr[j]){
                    break;
                }else if (j==num-1){
                    mark++;
                }
            }
        }
        return mark;
    }

    public static void main(String[] args) {
        leetcode2352 l = new leetcode2352();
        int[][] grid = {{3,2,1},{1,7,6},{2,7,7}};
        int res = l.equalPairs(grid);
        System.out.println(res);
    }
}
