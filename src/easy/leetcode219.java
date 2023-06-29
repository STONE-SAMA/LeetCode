package easy;

import java.util.*;

public class leetcode219 {
    /**
     * 存在重复元素 II
     * https://leetcode.cn/problems/contains-duplicate-ii
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (set.contains(temp)) {
                return true;
            } else {
                set.add(temp);
                if (set.size() > k) {
                    set.remove(nums[i - k]);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        leetcode219 l = new leetcode219();
        int[] nums = {1, 2, 3, 1, 2, 3};
        int k = 2;
        boolean res = l.containsNearbyDuplicate(nums, k);
        System.out.println(res);
    }

    public boolean containsNearbyDuplicate_old(int[] nums, int k) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            List<Integer> list;
            if (map.containsKey(temp)) {
                list = map.get(temp);
            } else {
                list = new ArrayList<>();
            }
            list.add(i);
            map.put(temp, list);
        }
        for (int key : map.keySet()) {
            List<Integer> list = map.get(key);
            if (list.size() > 1) {
                for (int i = 0; i < list.size() - 1; i++) {
                    int temp = Math.abs(list.get(i) - list.get(i + 1));
                    if (temp <= k) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
