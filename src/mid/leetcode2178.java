package mid;

import java.util.ArrayList;
import java.util.List;

public class leetcode2178 {
    /**
     * 拆分成最多数目的正偶数之和
     * https://leetcode.cn/problems/maximum-split-of-positive-even-integers/
     *
     * @param finalSum
     * @return
     */
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> list = new ArrayList<>();
        if (finalSum % 2 != 0) {
            return list;
        }
        long mark = 0;
        long i = 2;
        for (; ; i += 2) {
            if (mark + i <= finalSum) {
                list.add(i);
                mark += i;
            } else {
                Long last = list.remove(list.size() - 1);
                list.add(finalSum - mark + last);
                break;
            }
        }
        return list;
    }
}
