package easy;

public class leetcode2562 {
    /**
     * 找出数组的串联值
     * https://leetcode.cn/problems/find-the-array-concatenation-value/
     *
     * @param nums
     * @return
     */
    public long findTheArrayConcVal(int[] nums) {
        int len = nums.length;
        long res = 0;
        for (int i = 0; i < len / 2; i++) {
            String s = String.valueOf(nums[i]) + String.valueOf(nums[len - i - 1]);
            long sum = 0;
            for (int j = 0; j < s.length(); j++) {
                long temp = s.charAt(j) - '0';
                sum = sum * 10 + temp;
            }
            res += sum;
        }
        if (len % 2 != 0) {
            res += nums[len / 2];
        }
        return res;
    }
}
