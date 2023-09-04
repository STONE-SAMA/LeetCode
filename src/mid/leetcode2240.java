package mid;

public class leetcode2240 {
    /**
     * @param total
     * @param cost1
     * @param cost2
     * @return
     */
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        if (total < Math.min(cost1, cost2)) {
            return 1;
        }
        int a = total / cost1;
        int b = total / cost2;
        long mark = 0;
        for (int i = 0; i < a; i++) {
            int left = total - i * cost1;
            int temp = left / cost2;
            mark += temp + 1;

//            for (int j = 0; j < b; j++) {
//                if (i * cost1 + j * cost2 > total) {
//                    break;
//                } else {
//                    mark++;
//                }
//            }
        }
        return mark;
    }

    public static void main(String[] args) {
        leetcode2240 l = new leetcode2240();
        long res = l.waysToBuyPensPencils(1000000, 1, 1);
        System.out.println(res);

    }
}
