package mid;

public class leetcode1375 {
    /**
     * 二进制字符串前缀一致的次数
     * https://leetcode.cn/problems/number-of-times-binary-string-is-prefix-aligned/
     *
     * @param flips
     * @return
     */
    public int numTimesAllBlue(int[] flips) {
        int count = 0;
        int[] mark = new int[flips.length];
        for (int i = 0; i < flips.length; i++) {
            int temp = flips[i];
            mark[temp - 1] = mark[temp - 1] == 0 ? 1 : 0;
            boolean flag = true;
            for (int j=0;j<=i;j++){
                if (mark[j]!=1){
                    flag = false;
                    break;
                }
            }
            if (flag){
                count++;
            }
        }

        return count;
    }
}
