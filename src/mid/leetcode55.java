package mid;

public class leetcode55 {
    /**
     * 跳跃游戏
     * https://leetcode.cn/problems/jump-game/
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int cover = 0;
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(cover, nums[i] + i);
            if (cover >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
