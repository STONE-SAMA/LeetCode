package hard;

public class letcode982 {
    /*
    按位与为零的三元组
    https://leetcode.cn/problems/triples-with-bitwise-and-equal-to-zero/
     */
    public int countTriplets(int[] nums) {
        int[] arr = new int[1 << 16];
        for (int x : nums) {
            for (int y : nums) {
                arr[x & y]++;
            }
        }
        int res = 0;
        for (int x : nums) {
            for (int i = 0; i < (1 << 16); i++) {
                if ((x & i) == 0) {
                    res += arr[i];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        letcode982 l = new letcode982();
        int res;
        res = l.countTriplets(new int[]{0, 0, 0});
        System.out.println(res);
    }
}
