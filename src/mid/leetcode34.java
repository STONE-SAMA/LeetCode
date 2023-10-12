package mid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class leetcode34 {
    /**
     * 在排序数组中查找元素的第一个和最后一个位置
     * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int count = 0;
        int left = 0;
        int right = nums.length - 1;
        List<Integer> list = new ArrayList<>();
        while (count < nums.length && left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                for (int i = middle; i >= 0; i--) {
                    if (nums[i] == target) {
                        list.add(i);
                    } else {
                        break;
                    }
                }
//                if (middle+1< nums.length)
                for (int i = middle + 1; i < nums.length; i++) {
                    if (nums[i] == target) {
                        list.add(i);
                    } else {
                        break;
                    }
                }
                break;
            }
            count++;
        }
        if (list.size() == 0) {
            return new int[]{-1, -1};
        } else if (list.size() == 1) {
            return new int[]{list.get(0), list.get(0)};
        }
        Collections.sort(list);
        return new int[]{list.get(0), list.get(list.size() - 1)};

    }

    public static void main(String[] args) {
        leetcode34 l = new leetcode34();
        int[] nums = {5,7,8,8,8,8,8,8,10};
//        int[] nums = {8};
        int[] res = l.searchRange(nums, 8);
        System.out.printf(res[0]+" "+res[1]);

    }

}
