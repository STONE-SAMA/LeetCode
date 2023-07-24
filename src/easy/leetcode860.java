package easy;

import java.util.ArrayList;
import java.util.List;

public class leetcode860 {
    /**
     * 柠檬水找零
     * https://leetcode.cn/problems/lemonade-change/
     *
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        int[] arr = new int[2];
        for (int i = 0; i < bills.length; i++) {
            int temp = bills[i];
            if (temp == 5) {
                arr[0]++;
            } else if (temp == 10) {
                if (arr[0] > 0) {
                    arr[0]--;
                    arr[1]++;
                } else {
                    return false;
                }
            } else if (temp == 20) {
                if (arr[1] > 0 && arr[0] > 0) {
                    arr[1]--;
                    arr[0]--;
                } else if (arr[0] >= 3) {
                    arr[0] = arr[0] - 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
