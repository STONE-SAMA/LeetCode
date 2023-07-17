package mid;

import java.util.ArrayList;
import java.util.List;

public class leetcode57 {
    /**
     * 插入区间
     * https://leetcode.cn/problems/insert-interval/
     *
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length==0){
            return new int[][]{newInterval};
        }
        List<int[]> list = new ArrayList<>();
        int i = 0;
        for (; i < intervals.length; i++) {
            if (intervals[i][1] < newInterval[0]) {
                list.add(intervals[i]);
            } else {
                break;
            }
        }
        if (i==intervals.length){
            list.add(newInterval);
        } else if (newInterval[1]<intervals[i][0]) {
            list.add(newInterval);
            for (; i < intervals.length; i++) {
                list.add(intervals[i]);
            }
        } else {
            if (intervals[i][1] == newInterval[0]) {
                intervals[i][1] = newInterval[1];
            } else if (intervals[i][1] > newInterval[0]) {
                intervals[i][1] = Math.max(newInterval[1], intervals[i][1]);
            }
            intervals[i][0] = Math.min(intervals[i][0], newInterval[0]);
            int[] mark = intervals[i];
            i++;
            for (; i < intervals.length; i++) {
                if (intervals[i][1] <= mark[1]) continue;
                if (intervals[i][0] <= mark[1]) {
                    mark[1] = Math.max(mark[1], intervals[i][1]);
                } else {
                    break;
                }
            }
            list.add(mark);
            for (; i < intervals.length; i++) {
                list.add(intervals[i]);
            }
        }

        int[][] res = new int[list.size()][2];
        for (int j = 0; j < list.size(); j++) {
            res[j][0] = list.get(j)[0];
            res[j][1] = list.get(j)[1];
        }
        return res;
    }

    public static void main(String[] args) {
        leetcode57 l = new leetcode57();
        int[][] intervals = {{1,5}};
        int[] newInterval = {0,0};
        int[][] insert = l.insert(intervals, newInterval);

    }
}
