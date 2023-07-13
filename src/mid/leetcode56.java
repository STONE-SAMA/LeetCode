package mid;

import java.util.*;

public class leetcode56 {
    /**
     * 合并区间
     * https://leetcode.cn/problems/merge-intervals
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }

        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length - 1; i++) {
            int temp_left = intervals[i][0];
            int temp_right = intervals[i][1];
            if (temp_left <= right) {
                right = Math.max(right, temp_right);
            }
            if (temp_left > right) {
                int[] arr = new int[2];
                arr[0] = left;
                arr[1] = right;
                list.add(arr);
                left = temp_left;
                right = temp_right;
            }
        }
        //最后一个单独判断
        int temp_left = intervals[intervals.length - 1][0];
        int temp_right = intervals[intervals.length - 1][1];
        int[] arr = new int[2];
        if (temp_left <= right) {
            arr[0] = left;
            arr[1] = Math.max(right, temp_right);
            list.add(arr);
        } else {
            arr[0] = left;
            arr[1] = right;
            list.add(arr);
            arr = new int[2];//在同一个数组上更改，会导致覆盖问题
            arr[0] = temp_left;
            arr[1] = temp_right;
            list.add(arr);
        }

        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            int[] temp = list.get(i);
            res[i][0] = temp[0];
            res[i][1] = temp[1];
        }
        return res;
    }

    public static void main(String[] args) {
        leetcode56 l = new leetcode56();
        int[][] nums = {{1,3},{15,18},{8,10},{2,6}};
        int[][] merge = l.merge(nums);
        for(int[] arr : merge){
            for (int num:arr){
                System.out.printf(String.valueOf(num));
                System.out.printf(" ");
            }
            System.out.println();
        }
    }
}
