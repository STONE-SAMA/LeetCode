package mid;

import java.util.*;

public class leetcode1090 {
    /*
    受标签影响的最大值
    https://leetcode.cn/problems/largest-values-from-labels/
     */
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int[][] arr = new int[values.length][2];
        for (int i = 0; i < values.length; i++) {
            arr[i][0] = values[i];
            arr[i][1] = labels[i];
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                } else {
                    return o2[0] - o1[0];
                }
            }
        });

        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            if (list.size() == numWanted) {
                break;
            } else {
                int label = arr[i][1];
                if (!map.containsKey(label)) {
                    map.put(label, 1);
                    list.add(arr[i][0]);
                } else {
                    if (map.get(label) < useLimit) {
                        list.add(arr[i][0]);
                        map.put(label, map.get(label) + 1);
                    }
                }
            }
        }

        int res = 0;
        for (int i = 0; i < list.size(); i++) {
            res += list.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
        leetcode1090 l = new leetcode1090();
        int[] values = {9, 8, 8, 7, 6};
        int[] labels = {0, 0, 0, 1, 1};
        int numWanted = 3;
        int useLimit = 1;

        int res = l.largestValsFromLabels(values, labels, numWanted, useLimit);
        System.out.println(res);

    }
}
