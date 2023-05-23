public class letcode1144 {
    /*
    递减元素使数组呈锯齿状
    https://leetcode.cn/problems/decrease-elements-to-make-array-zigzag/
     */
    public int movesToMakeZigzag(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int count_odd = 0;
        int count_even = 0;
        int[] arr = new int[nums.length];
        for (int i=0;i< nums.length;i++){
            arr[i] = nums[i];
        }
        // 对偶数位操作
        for (int i = 0; i < nums.length; i += 2) {

            if (i == 0) {
                if (arr[i + 1] >= arr[i]) {
                    count_even += arr[i + 1] - arr[i] + 1;
                    arr[i + 1] = arr[i] - 1;
                }
            } else if (i == (nums.length - 1)) {
                if (arr[i - 1] >= arr[i]) {
                    count_even += arr[i - 1] - arr[i] + 1;
                    arr[i - 1] = arr[i] - 1;
                }
            }else {
                if (arr[i + 1] >= arr[i]) {
                    count_even += arr[i + 1] - arr[i] + 1;
                    arr[i + 1] = arr[i] - 1;
                }
                if (arr[i - 1] >= arr[i]) {
                    count_even += arr[i - 1] - arr[i] + 1;
                    arr[i - 1] = arr[i] - 1;
                }
            }
        }
        // 对奇数位操作
        for (int i = 1; i < nums.length; i += 2) {
            if (nums[i - 1] >= nums[i]) {
                count_odd += nums[i - 1] - nums[i] + 1;
                nums[i - 1] = nums[i] - 1;
            }
            if (i + 1 < nums.length) {
                if (nums[i + 1] >= nums[i]) {
                    count_odd += nums[i + 1] - nums[i] + 1;
                    nums[i + 1] = nums[i] - 1;
                }
            }
        }
        return Math.min(count_odd, count_even);
    }

    public static void main(String[] args) {
        letcode1144 l = new letcode1144();
//        l.movesToMakeZigzag(new int[]{9, 6, 1, 6, 2});
        l.movesToMakeZigzag(new int[]{7,4,8,9,7,7,5});
    }

}
