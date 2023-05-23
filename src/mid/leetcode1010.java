package mid;

public class leetcode1010 {
    /*
    总持续时间可被 60 整除的歌曲
    https://leetcode.cn/problems/pairs-of-songs-with-total-durations-divisible-by-60/
     */
    public int numPairsDivisibleBy60(int[] time) {
        int res = 0;
        int[] arr = new int[60];
        for (int t : time) {
            int left = t % 60;
            res += arr[(60 - left) % 60];
            arr[left]++;
        }

        return res;
    }
}
