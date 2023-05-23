import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.DoubleStream;

public class letcode1792 {
    /*
    最大平均通过率
    https://leetcode.cn/problems/maximum-average-pass-ratio/
     */
    public double maxAverageRatio_dui(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> {
            double x = (a[0] + 1) / (a[1] + 1) - a[0] / a[1];
            double y = (b[0] + 1) / (b[1] + 1) - b[0] / b[1];
            return Double.compare(y, x);
        });
        for (var e : classes) {
            pq.offer(new double[] {e[0], e[1]});
        }
        while (extraStudents-- > 0) {
            var e = pq.poll();
            double a = e[0] + 1, b = e[1] + 1;
            pq.offer(new double[] {a, b});
        }
        double ans = 0;
        while (!pq.isEmpty()) {
            var e = pq.poll();
            ans += e[0] / e[1];
        }
        return ans / classes.length;
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        DecimalFormat d = new DecimalFormat(".00000");

        while (extraStudents != 0) {
            double max = 0;
            int index = 0;//当前插入收益最大位置
            for (int i = 0; i < classes.length; i++) {
                double add = ((double) (classes[i][0] + 1) / (double) (classes[i][1] + 1)) -
                        ((double) classes[i][0] / (double) classes[i][1]);
                if (add>max){
                    max = add;
                    index = i;
                }
            }
            classes[index][0]+=1;
            classes[index][1]+=1;
            extraStudents--;
        }
        double sum = 0;
        for (int i=0;i< classes.length;i++){
            double temp = (double) classes[i][0] / (double) classes[i][1];
            sum+=temp;
        }

        return Double.parseDouble(d.format(sum / (double) classes.length));
    }

    public static void main(String[] args) {
        letcode1792 l = new letcode1792();
        int[][] arr = {{1, 2}, {3, 5}, {2, 2}};
        double res = l.maxAverageRatio(arr, 2);
        System.out.println(res);
    }
}
