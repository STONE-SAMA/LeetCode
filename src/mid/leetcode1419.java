package mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode1419 {
    /*
    数青蛙
    https://leetcode.cn/problems/minimum-number-of-frogs-croaking/
     */
    public int minNumberOfFrogs(String croakOfFrogs) {
        int[] count = new int[5];
        int max = 0;
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            char c = croakOfFrogs.charAt(i);
            if (c == 'c') {
                count[0]++;
            } else if (c == 'r') {
                count[1]++;
                if (count[2] > count[1] || count[3] > count[1] || count[4] > count[1] || count[1] > count[0]) {
                    return -1;
                }
            } else if (c == 'o') {
                count[2]++;
                if (count[3] > count[2] || count[4] > count[2] || count[2] > count[1] || count[2] > count[0]) {
                    return -1;
                }
            } else if (c == 'a') {
                count[3]++;
                if (count[4] > count[3] || count[3] > count[2] || count[3] > count[1] || count[3] > count[0]) {
                    return -1;
                }
            } else if (c == 'k') {
                count[4]++;
                max = Math.max(max, count[0]);
                if (count[0] == count[1] && count[1] == count[2] && count[2] == count[3] && count[3] == count[4]) {
                    for (int j = 0; j < 5; j++) {
                        count[j] = 0;
                    }
                } else {
                    for (int j = 0; j < 5; j++) {
                        count[j]--;
                    }
                }

            }
        }
        for (int j = 0; j < 5; j++) {
            if (count[j] != 0) {
                return -1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        leetcode1419 l = new leetcode1419();
//        String str = "crocakcroraoakk";
        String str = "croakcrook";
        int res = l.minNumberOfFrogs(str);
        System.out.println(res);
    }
}
