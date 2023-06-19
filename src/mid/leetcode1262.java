package mid;

import java.util.*;

public class leetcode1262 {
    /**
     * 可被三整除的最大和
     * https://leetcode.cn/problems/greatest-sum-divisible-by-three/
     *
     * @param nums
     * @return
     */
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int temp = nums[i] % 3;
            if (temp == 1) {
                list1.add(nums[i]);
            } else if (temp == 2) {
                list2.add(nums[i]);
            }
        }
        if (sum % 3 == 0) {
            return sum;
        }
        Collections.sort(list1);
        Collections.sort(list2);

        int mark = Integer.MAX_VALUE;
        if (sum % 3 == 1) {
            if (list1.size() >= 1) {
                mark = Math.min(mark, list1.get(0));
            }
            if (list2.size() >= 2) {
                mark = Math.min(mark, list2.get(0) + list2.get(1));
            }
        } else {
            if (list1.size() >= 2) {
                mark = Math.min(mark, list1.get(0) + list1.get(1));
            }
            if (list2.size() >= 1) {
                mark = Math.min(mark, list2.get(0));
            }

        }
        return sum - mark;
    }
}
