package mid;

public class letcode11 {
    /*
    盛最多水的容器
    https://leetcode.cn/problems/container-with-most-water/
     */
    public int maxArea(int[] height){
        int num = height.length;
        int max = 0;
        int i=0;
        int j=num-1;
        while (i!=j){
            int temp = Math.min(height[i], height[j]) * (j - i);
            if (max < temp) {
                max = temp;
            }
            if (height[i]>=height[j]){
                j--;
            }else {
                i++;
            }
        }
        return max;
    }

    public int maxArea_n2(int[] height) {
        int num = height.length;
        int max = 0;
        for (int i = 0; i < num; i++) {
            for (int j = num - 1; j > i; j--) {
                int temp = Math.min(height[i], height[j]) * (j - i);
                if (max < temp) {
                    max = temp;
                }
            }
        }
        return max;
    }
}
