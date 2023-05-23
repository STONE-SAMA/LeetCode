package mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode1630 {
    /*
    等差子数组
    https://leetcode.cn/problems/arithmetic-subarrays/
     */
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int len = l.length;
        List<Boolean> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int length = r[i] - l[i] + 1;
            int[] arr = new int[length];
            for (int j = 0; j < length; j++) {
                arr[j] = nums[l[i] + j];
            }
            Arrays.sort(arr);
            boolean flag = true;
            int mark = arr[1] - arr[0];
            for (int j = 0; j < length-1; j++) {
                if (arr[j+1]-arr[j]!=mark){
                    flag = false;
                    break;
                }
            }
            list.add(flag);
        }
        return list;
    }
}
