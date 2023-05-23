package easy;

import java.util.ArrayList;
import java.util.List;

public class leetcode2432 {
    /*
    处理用时最长的那个任务的员工
    https://leetcode.cn/problems/the-employee-that-worked-on-the-longest-task/
     */
    public int hardestWorker(int n, int[][] logs) {
        int[] arr = new int[n];
        int temp = 0;
        for (int i = 0; i < logs.length; i++) {
            int cost = logs[i][1] - temp;
            arr[logs[i][0]] = Math.max(cost, arr[logs[i][0]]);
            temp = logs[i][1];
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (arr[max] < arr[i]) {
                max = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        leetcode2432 l = new leetcode2432();
        int[][] logs = {{0, 3}, {2, 5}, {0, 9}, {1, 15}};
        int res = l.hardestWorker(10, logs);
        System.out.println(res);
    }


}
