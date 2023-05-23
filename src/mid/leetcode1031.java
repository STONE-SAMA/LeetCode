package mid;

public class leetcode1031 {
    /*
    两个非重叠子数组的最大和
    https://leetcode.cn/problems/maximum-sum-of-two-non-overlapping-subarrays/
     */
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int len = nums.length;
        //前缀和
        int[] arr = new int[len + 1];
        for (int i = 0; i < len; i++) {
            arr[i + 1] = arr[i] + nums[i];
        }
        // firstLen在左 secondLen在右
        int max_1 = 0;
        for (int i = firstLen; i <= len - secondLen; i++) {
            int temp = arr[i] - arr[i - firstLen];
            int max_right = 0;
            for (int j = i + secondLen; j <= len; j++) {
                max_right = Math.max(arr[j] - arr[j - secondLen], max_right);
            }
            temp += max_right;
            max_1 = Math.max(max_1, temp);
        }
        // firstLen在右 secondLen在左
        int max_2 = 0;
        for (int i = secondLen; i <= len - firstLen; i++) {
            int temp = arr[i] - arr[i - secondLen];
            int max_right = 0;
            for (int j = firstLen + i; j <= len; j++) {
                max_right = Math.max(arr[j] - arr[j - firstLen], max_right);
            }
            temp += max_right;
            max_2 = Math.max(max_2, temp);
        }
        return Math.max(max_1, max_2);
    }

    public static void main(String[] args) {
        leetcode1031 l = new leetcode1031();
        int[] nums = {2, 1, 5, 6, 0, 9, 5, 0, 3, 8};
        int left = 4;
        int right = 3;
        int res = l.maxSumTwoNoOverlap(nums, left, right);
        System.out.println(res);
    }
}
