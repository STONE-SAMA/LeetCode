package easy;

public class leetcode2475 {
    /**
     * 数组中不等三元组的数目
     * https://leetcode.cn/problems/number-of-unequal-triplets-in-array/
     * @param nums
     * @return
     */
    public int unequalTriplets(int[] nums) {
        int count = 0;

        for (int i=0;i< nums.length-2;i++){
            for (int j=i+1;j< nums.length-1;j++){
                if (nums[i]!=nums[j]){
                    for (int k = j+1;k< nums.length;k++){
                        if (nums[k]!=nums[i]&&nums[k]!=nums[j]){
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }
}
