package mid;

public class leetcode45 {
    /**
     * 跳跃游戏 II
     * https://leetcode.cn/problems/jump-game-ii
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int steps = 0;
        int start = 0;
        int end = 1;
        while (end < length) {
            int max = 0;
            for (int i = start; i < end; i++) {
                max = Math.max(max, i + nums[i]);
            }
            start = end;
            end = max + 1;
            steps++;
        }
        return steps;
    }
}
