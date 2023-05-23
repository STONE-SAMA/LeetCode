package mid;

import java.util.Arrays;

public class leetcode1043 {
    /*
    分隔数组以得到最大和
    https://leetcode.cn/problems/partition-array-for-maximum-sum/
     */
    private int res;
    private int step;

    public int maxSumAfterPartitioning(int[] arr, int k) {
        step = k;
        dfs(arr);
        return res;
    }

    private void dfs(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        if (arr.length == 1) {
            res += arr[0];
            return;
        }
        int max = arr[0];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }
        if (arr.length > step) {
            res += max * step;
        } else {
            res += max * arr.length;
        }
        //查找最佳分割点
        int min_start = 0;
        if (index - step + 1 > min_start) {
            min_start = index - step + 1;
        }
        int max_start = index;
        if (max_start + step > arr.length) {
            max_start = arr.length - step;
        }
        index = min_start;
        int min_sum = max * step;
        for (int i = min_start; i <= max_start; i++) {
            int sum = 0;
            for (int j = 0; j < step; j++) {
                sum += arr[j];
            }
            if (sum < min_sum) {
                min_sum = sum;
                index = i;
            }
        }
        //分割数组
        int[] before = Arrays.copyOfRange(arr, 0, index);
        dfs(before);
        if (index + step < arr.length) {
            int[] after = Arrays.copyOfRange(arr, index + step, arr.length);
            dfs(after);
        }
    }

    public static void main(String[] args) {
        leetcode1043 l = new leetcode1043();
        int[] arr = {1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3};
        int k = 4;
        int ans = l.maxSumAfterPartitioning(arr, k);
        System.out.println(ans);
    }

}
