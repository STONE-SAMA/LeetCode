package mid;

public class leetcode1590 {
    /*
    使数组和能被 P 整除
    https://leetcode.cn/problems/make-sum-divisible-by-p/
     */
    public int minSubarray(int[] nums, int p) {
        //超时
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % p == 0) {
            return 0;
        }
        int min = nums.length;
        for (int i = nums.length; i > 0; i--) {
            long temp = 0;
            for (int j = 1; j <= i; j++) {
                temp += nums[i-j];
                if ((sum - temp) % p == 0) {
                    if (min > j) {
                        min = j;
                    }
                    break;
                }
            }
        }
        return min == nums.length ? -1 : min;
    }

    public static void main(String[] args) {
        int[] arr = {8,32,31,18,34,20,21,13,1,27,23,22,11,15,30,4,2};
        int p = 148;
        leetcode1590 l = new leetcode1590();
        int res = l.minSubarray(arr, p);
        System.out.println(res);
    }
}
