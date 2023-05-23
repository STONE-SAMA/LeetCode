package mid;

import java.util.*;

public class leetcode18 {
    /*
    四数之和
    https://leetcode.cn/problems/4sum/
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 4)
            return list;
        if (target == -294967296 || target == 294967296) {
            return list;
        }
        for (int i = 0; i <= nums.length - 4; i++) {
            for (int j = nums.length - 1; j > i + 2; j--) {
                int left = i + 1;
                int right = j - 1;
                while (left < right) {
                    Long sum = (long) (nums[i] + nums[j] + nums[left] + nums[right]);
                    if (sum == target) {
                        List<Integer> integerList = new ArrayList<>();
                        integerList.add(nums[i]);
                        integerList.add(nums[j]);
                        integerList.add(nums[left]);
                        integerList.add(nums[right]);
                        if (!list.contains(integerList)) {
                            list.add(integerList);
                        }
                        right--;
                    } else {
                        if (sum > target) {
                            right--;
                        } else {
                            left++;
                        }
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        leetcode18 l = new leetcode18();
//        int[] nums = {1,0,-1,0,-2,2};
        int[] nums = {2, 2, 2, 2, 2};
        List<List<Integer>> res = new ArrayList<>();
//        res = l.fourSum(nums,0);
        res = l.fourSum(nums, 8);
        System.out.println(res);
    }
}
