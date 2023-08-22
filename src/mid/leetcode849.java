package mid;

public class leetcode849 {
    /**
     * 到最近的人的最大距离
     * https://leetcode.cn/problems/maximize-distance-to-closest-person/
     *
     * @param seats
     * @return
     */
    public int maxDistToClosest(int[] seats) {
        if (seats.length == 2) {
            return 1;
        }
        int res = -1;
        int left;
        if (seats[0] == 1) {
            left = 0;
        } else {
            int index = 1;
            while (seats[index] == 0) {
                index++;
            }
            res = index;
            left = index;
        }
        for (int i = left + 1; i < seats.length; i++) {
            if (seats[i] == 1) {
                //计算当前距离
                int temp = i - left;
                if (temp/2 > res) {
                    res = temp / 2;
                }
                left = i;
            }
        }
        if (left != seats.length - 1) {
            int temp = seats.length -1 - left;
            if (temp > res) {
                res = temp;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        leetcode849 l = new leetcode849();
        int[] seats = {0,1,1,1,0,0,1,0,0};
        int i = l.maxDistToClosest(seats);
        System.out.println(i);
    }
}
