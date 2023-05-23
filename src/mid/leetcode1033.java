package mid;

public class leetcode1033 {
    /*
    移动石子直到连续
    https://leetcode.cn/problems/moving-stones-until-consecutive/
     */
    public int[] numMovesStones(int a, int b, int c) {
        int left = Math.min(a, b);
        left = Math.min(left, c);
        int right = Math.max(a, b);
        right = Math.max(right, c);
        int middle;
        if (a != left && a != right) {
            middle = a;
        } else if (b != left && b != right) {
            middle = b;
        } else {
            middle = c;
        }

        if (left + 1 == middle && middle + 1 == right) {
            return new int[]{0, 0};
        } else if (left + 1 == middle || middle + 1 == right) {
            return new int[]{1, right - left - 2};
        } else if (left + 2 == middle || middle + 2 == right) {
            return new int[]{1, right - left - 2};
        } else {
            return new int[]{2, right - left - 2};
        }
    }

    public static void main(String[] args) {
        leetcode1033 l = new leetcode1033();
        int[] res = l.numMovesStones(3, 1, 5);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }

}
