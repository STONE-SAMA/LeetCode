package mid;

public class leetcode1186 {
    /**
     * 删除一次得到子数组最大和
     * https://leetcode.cn/problems/maximum-subarray-sum-with-one-deletion/
     *
     * @param arr
     * @return
     */
    public int maximumSum(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        int[][] dp = new int[arr.length][2];
        dp[0][0] = arr[0];//当前元素最大和
        dp[0][1] = 0;//删除一个元素最大和
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], 0) + arr[i];
            dp[i][1] = Math.max(dp[i - 1][1] + arr[i], dp[i - 1][0]);
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }
        return max;
    }

    public static void main(String[] args) {
        leetcode1186 l = new leetcode1186();
        int[] arr = {-7,6,1,2,1,4,-1};
        int res = l.maximumSum(arr);
        System.out.println(res);
    }
}
