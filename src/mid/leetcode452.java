package mid;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class leetcode452 {
    /**
     * 用最少数量的箭引爆气球
     * https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons
     *
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points) {
        if (points.length == 1) {
            return 1;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return Integer.compare(o1[1],o2[1]);
                }
                return Integer.compare(o1[0],o2[0]);
            }
        });
        //相当于合并区间(保留合并区间，丢弃原有区间，若区间无重叠则也保留)
        Stack<int[]> stack = new Stack<>();
        stack.push(points[0]);
        for (int i = 1; i < points.length; i++) {
            int left = points[i][0];
            int right = points[i][1];
            int stack_left = stack.peek()[0];
            int stack_right = stack.peek()[1];
            if (left > stack_right) {
                stack.push(points[i]);
            } else if (left == stack_right) {
                stack.pop();
                stack.push(new int[]{left, left});
            } else {
                stack.pop();
                stack.push(new int[]{Math.max(left, stack_left), Math.min(right, stack_right)});
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        leetcode452 l = new leetcode452();
        int[][] points = {{10, 15}, {4, 8}, {4, 5}};
        int res = l.findMinArrowShots(points);
        System.out.println(res);

    }
}
