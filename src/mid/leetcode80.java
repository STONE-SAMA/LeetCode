package mid;

import java.util.Arrays;
import java.util.HashMap;

public class leetcode80 {
    /**
     * 删除有序数组中的重复项 II
     * https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        //通过两个指针进行遍历
        if (nums.length < 3) {
            return nums.length;
        }
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (slow < 2 || nums[fast] != nums[slow - 2]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    public int removeDuplicates_old(int[] nums) {
        //对数组从前往后遍历，用一个hashmap来记录当前数字已出现过的次数，
        //在数组最后用一个指针，当前数字超过两次时，与数组尾部元素交换
        if (nums.length < 3) {
            return nums.length;
        }
        int index = nums.length - 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int count = 0;
        while (i < index) {
            int temp = nums[i];
            if (!map.containsKey(temp)) {
                map.put(temp, 1);
                i++;
                count++;
            } else if (map.get(temp) < 2) {
                map.put(temp, 2);
                i++;
                count++;
            } else {
                nums[i] = nums[index];
                index--;
            }
        }
        if (!map.containsKey(nums[index])) {
            count++;
        } else if (map.get(nums[index]) < 2) {
            count++;
        }
        Arrays.sort(nums, 0, Math.min(count, nums.length));
        return count;
    }

    public static void main(String[] args) {
        leetcode80 l = new leetcode80();
//        int[] nums = {1, 1, 1, 1, 2, 2, 3};
        int[] nums = {1, 1, 1, 2, 2, 3};
        int res = l.removeDuplicates(nums);
        System.out.println(res);
        for (int i = 0; i < res; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
