package mid;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class leetcode1615 {
    /*
    最大网络秩
    https://leetcode.cn/problems/maximal-network-rank/
     */
    public int maximalNetworkRank(int n, int[][] roads) {
        int[][] arr = new int[n][n];
        int[] mark = new int[n];
        for (int i = 0; i < roads.length; i++) {
            int a = roads[i][0];
            int b = roads[i][1];
            arr[a][b] = 1;
            arr[b][a] = 1;
            mark[a]++;
            mark[b]++;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = mark[i] + mark[j] - arr[i][j];
                max = Math.max(max, temp);
            }
        }
        return max;
    }

    public int maximalNetworkRank_old(int n, int[][] roads) {
        int[][] arr = new int[n][n];
        for (int i = 0; i < roads.length; i++) {
            int a = roads[i][0];
            int b = roads[i][1];
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        int[][] mark = new int[n][2];
        int max = -1;
        int index = -1;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != 0) {
                    count++;
                }
            }
            mark[i][0] = count;
            mark[i][1] = i;
            if (max < count) {
                max = count;
                index = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[index][i] != 0) {
                if (mark[i][0] > 0) {
                    mark[i][0]--;
                }
            }
        }
        Arrays.sort(mark, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        int res = mark[0][0] + mark[1][0];
        return res;
    }

    public static void main(String[] args) {
        leetcode1615 l = new leetcode1615();

//        int[][] num = {{0, 1}, {1, 2}, {2, 3}, {2, 4}, {5, 6}, {5, 7}};
//        int res = l.maximalNetworkRank(8, num);

//        int[][] num = {{0, 1}, {0, 3}, {1, 2}, {1, 3}};
//        int res = l.maximalNetworkRank(4, num);

        int[][] num = {{2, 3}, {0, 3}, {0, 4}, {4, 1}};
        int res = l.maximalNetworkRank(5, num);

        System.out.println(res);
    }
}
