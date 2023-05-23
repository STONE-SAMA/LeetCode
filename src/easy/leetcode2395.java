package easy;

import java.util.ArrayList;
import java.util.List;

public class leetcode2395 {
    public boolean findSubarrays(int[] nums) {
        int len = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len - 1; i++) {
            int temp = nums[i] + nums[i + 1];
            if (list.contains(temp)) {
                return true;
            } else {
                list.add(temp);
            }
        }
        return false;
    }
}
