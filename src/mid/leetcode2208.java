package mid;

import java.util.*;

public class leetcode2208 {
    /**
     * 将数组和减半的最少操作次数
     * https://leetcode.cn/problems/minimum-operations-to-halve-array-sum/
     *
     * @param nums
     * @return
     */
    public int halveArray(int[] nums) {
//        PriorityQueue<Double> priorityQueue = new PriorityQueue<>(new Comparator<Double>() {
//            @Override
//            public int compare(Double o1, Double o2) {
//                return Double.compare(o1, o2);
//            }
//        });
        PriorityQueue<Double> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        double sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (double) nums[i];
            priorityQueue.offer((double) nums[i]);
        }
        if (sum == 0) {
            return 0;
        }
        double half = sum / 2.0;
        int count = 0;
        while (half > 0) {
            double value = priorityQueue.poll();
            half -= value / 2.0;
            priorityQueue.offer(value / 2.0);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        leetcode2208 l = new leetcode2208();
        int[] nums = {18, 22, 62, 61, 1, 88, 17, 98, 38, 32, 51, 57, 7, 29, 40, 61, 62, 13, 89, 41, 73, 85, 88, 60, 59, 76, 71, 76, 76, 41, 29, 43, 19, 9, 79};
        int i = l.halveArray(nums);
        System.out.println(i);
    }
}
