package easy;

import java.util.ArrayList;

public class leetcode26 {
    /*
    删除有序数组中的重复项
    https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
     */
    public int removeDuplicates(int[] nums) {
        int count = 1;
        ArrayList<Integer> arrayList = new ArrayList<>();
        int before = nums[0];
        arrayList.add(before);
        for (int i = 1; i < nums.length; i++) {
            if (before!=nums[i]){
                arrayList.add(nums[i]);
                before = nums[i];
                count++;
            }
        }
        for (int i=0;i<arrayList.size();i++){
            nums[i] = arrayList.get(i);
        }
        return count;
    }
}
