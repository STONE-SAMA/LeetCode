package mid;

public class leetcode134 {
    /**
     * 加油站
     * https://leetcode.cn/problems/gas-station
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] minus = new int[gas.length];
        int sum = 0;
        int index = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < gas.length; i++) {
            minus[i] = gas[i] - cost[i];
            sum += minus[i];
            if (min > sum) {
                min = sum;
                index = i;
            }
        }
        if (sum < 0) {
            return -1;
        }
        int res = index + 1 == gas.length ? 0 : index + 1;
        while (minus[res] < 0) {
            if (res + 1 < gas.length) {
                res++;
            } else {
                res = 0;
            }
        }
        return res;
    }
}
