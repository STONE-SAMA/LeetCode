package mid;

import java.util.Arrays;

public class leetcode2611 {
    /**
     * 老鼠和奶酪
     * https://leetcode.cn/problems/mice-and-cheese/
     *
     * @param reward1
     * @param reward2
     * @param k
     * @return
     */
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int sum = 0;
        int[] arr = new int[reward1.length];//存放差值
        for (int i = 0; i < reward1.length; i++) {
            sum += reward2[i];
            arr[i] = reward1[i] - reward2[i];
        }
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            sum += arr[reward1.length - 1 - i];
        }
        return sum;
    }
}
