import java.util.Arrays;

public class letcode2357 {
    /*
    使数组中所有元素都等于零
    https://leetcode.cn/problems/make-array-zero-by-subtracting-equal-amounts/
     */
    public int minimumOperations(int[] nums) {
        int step = 0;
        Arrays.sort(nums);
        int i = 0;
        int temp = 0;
        while (nums[nums.length - 1] - temp > 0) {
            for (; i < nums.length; i++) {
                if (nums[i] - temp > 0) {
                    temp += nums[i] - temp;
                    step += 1;
                    break;
                }
            }
        }
        return step;
    }

    public static void main(String[] args) {
        letcode2357 l = new letcode2357();
        l.minimumOperations(new int[]{1, 2, 3, 5});
    }
}
