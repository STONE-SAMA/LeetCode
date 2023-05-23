import java.util.ArrayList;
import java.util.Collections;

public class letcode2373 {
    /*
    矩阵中的局部最大值
    https://leetcode.cn/problems/largest-local-values-in-a-matrix/
     */
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] res = new int[n-2][n-2];
        for (int i=1;i<n-1;i++){
            for (int j=1;j<n-1;j++){
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(grid[i-1][j-1]);
                arrayList.add(grid[i-1][j]);
                arrayList.add(grid[i-1][j+1]);
                arrayList.add(grid[i][j-1]);
                arrayList.add(grid[i][j]);
                arrayList.add(grid[i][j+1]);
                arrayList.add(grid[i+1][j-1]);
                arrayList.add(grid[i+1][j]);
                arrayList.add(grid[i+1][j+1]);
                Collections.sort(arrayList);
                res[i-1][j-1] = arrayList.get(arrayList.size()-1);
            }
        }
        return res;
    }
}
