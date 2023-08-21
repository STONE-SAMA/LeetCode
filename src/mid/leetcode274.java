package mid;

import java.util.Arrays;
import java.util.Comparator;

public class leetcode274 {
    /**
     * H 指数
     * https://leetcode.cn/problems/h-index
     *
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        Integer[] arr = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        if (arr[0] == 0) {
            return 0;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < i + 1) {
                return i;
            }
        }
        return arr.length;
    }
}
