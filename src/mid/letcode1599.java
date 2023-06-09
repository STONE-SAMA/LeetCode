package mid;

import java.io.IOException;
import java.util.Scanner;

public class letcode1599 {
    /*
    经营摩天轮的最大利润
    https://leetcode.cn/problems/maximum-profit-of-operating-a-centennial-wheel/
     */
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int round = 0;
        int max = 0;
        int wait = 0;//等待人数
        int profit = 0;
        int mark = 1;//当前轮次
        int i = 0;
        while (i < customers.length || wait != 0) {
            if (i < customers.length) {
                wait += customers[i];
                i++;
            }
            if (wait >= 4) {
                wait -= 4;
                profit += 4 * boardingCost - runningCost;
            } else {
                profit += wait * boardingCost - runningCost;
                wait = 0;
            }
            if (profit > max) {
                max = profit;
                round = mark;
            }
            mark++;
        }
        return profit > 0 ? round : -1;
    }

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();

//        int i = System.in.read();
        System.out.println(i);

        letcode1599 l = new letcode1599();
        int res;
        res = l.minOperationsMaxProfit(new int[]{8, 3}, 5, 6);
        System.out.println(res);
    }
}
