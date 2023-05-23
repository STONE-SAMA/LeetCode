package easy;

import java.util.ArrayList;
import java.util.Arrays;

public class leetcode2427 {
    /*
    公因子的数目
    https://leetcode.cn/problems/number-of-common-factors/
     */
    public int commonFactors(int a, int b) {
        ArrayList<Integer> res_a = yin_zi(a);
        ArrayList<Integer> res_b = yin_zi(b);
        int count = 0;
        for (Integer x : res_a) {
            if (res_b.contains(x)) {
                count++;
            }
        }
        return count;
    }

    private ArrayList<Integer> yin_zi(int num) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                if (!arrayList.contains(i)) {
                    arrayList.add(i);
                }
                if (!arrayList.contains(num / i)) {
                    arrayList.add(num / i);
                }
            }
        }
        return arrayList;
    }
}
