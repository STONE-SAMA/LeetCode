package mid;

import java.util.Arrays;

public class letcode16 {
    /*
    最接近的三数之和
    https://leetcode.cn/problems/3sum-closest/
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int a;//保存当前最接近时的和
        int b;//保存当前差值
        a = nums[0] + nums[1] + nums[2];
        b = Math.abs(target - a);
        for (int i = 0; i < nums.length; i++) {
            int x = i + 1;//左指针
            int y = nums.length - 1;//右指针
            while (x < y) {
                int sum = nums[i] + nums[x] + nums[y];
                if (sum == target) {
                    return target;
                } else {
                    int temp = target-sum;//保存当前差值
                    if (Math.abs(temp)<b){
                        b = Math.abs(temp);
                        a = sum;
                    }
                    if (sum<target){
                        x++;
                    }else {
                        y--;
                    }
                }
            }
        }
        return a;
    }
}
