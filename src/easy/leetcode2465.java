package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode2465 {
    /**
     * 不同的平均值数目
     * https://leetcode.cn/problems/number-of-distinct-averages/
     *
     * @param nums
     * @return
     */
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        if (nums[0]==nums[nums.length-1]){
            return 1;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int num = nums.length;

        List<Float> list = new ArrayList<>();
        int index = 0;
        while (sum != 0) {
            sum = sum - nums[index] - nums[num - index - 1];
            float temp = (float) (nums[index] + nums[num - index - 1]) / 2;
            if (!list.contains(temp)) {
                list.add(temp);
            }
            index++;
        }
        return list.size();
    }

    public static void main(String[] args) {
        leetcode2465 l = new leetcode2465();
        int[] nums = {4,1,4,0,3,5};
        int res = l.distinctAverages(nums);
        System.out.println(res);
    }
}
