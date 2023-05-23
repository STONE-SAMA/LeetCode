package easy;

public class leetcode2367 {
    /*
    算术三元组的数目
    https://leetcode.cn/problems/number-of-arithmetic-triplets/
     */
    public int arithmeticTriplets(int[] nums, int diff) {
        int count = 0;
        int num = nums.length;
        for (int i = 0; i < num - 2; i++) {
            for (int j = i + 1; j < num - 1; j++) {
                if (nums[j] - nums[i]==diff){
                    for (int k = j + 1; k < num; k++) {
                        if (nums[k]-nums[j]==diff){
                            count++;
                        }else if (nums[k]-nums[j]>diff){
                            break;
                        }
                    }
                }
            }
        }
        return count;
    }
}
