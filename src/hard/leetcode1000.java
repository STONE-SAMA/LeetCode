package hard;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode1000 {
    /*
    合并石头的最低成本
    https://leetcode.cn/problems/minimum-cost-to-merge-stones/
     */
    public int mergeStones(int[] stones, int k) {
        int len = stones.length;
        if (len == 1) {
            return 0;
        }

        float num = (float) (len - 1) / (k - 1);

        if (num % 1 != 0) {
            return -1;
        }

        int count = 0;

        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            linkedList.add(stones[i]);
        }

        for (int i = 0; i < num - 1; i++) {
            int[] res = place(linkedList, k);
            int index = res[0];
            int sum = res[1];
//            count += sum - res[2];
            count += sum;
            for (int j = 1; j < k; j++) {
                linkedList.remove(index);
            }
            linkedList.set(index, sum);
        }
        int[] res = place(linkedList, k);
//        count += res[1] - res[2];
        count += res[1];
        return count;
    }

    private int[] place(LinkedList<Integer> list, int k) {
        int[] res = new int[2];//第一个是删除起始位置;第二个是删除总和;
//        int[] res = new int[3];//第一个是删除起始位置;第二个是删除总和;第三个是删除元素中的最大元素
        int min = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            min += list.get(i);
            queue.add(list.get(i));
        }
        int index = 0;
        if (list.size() != k) {
            int temp = min;
            for (int i = 1; i <= list.size() - k; i++) {
                int num = list.get(i + k - 1);
                temp = temp - queue.remove() + num;
                queue.add(num);
                if (temp < min) {
                    index = i;
                    min = temp;
                }
            }
        }
//        int max = 0;
//        for (int i = 0; i < k; i++) {
//            int flag = list.get(index + i);
//            if (flag > max) {
//                max = flag;
//            }
//        }

        res[0] = index;
        res[1] = min;
//        res[2] = max;
        return res;
    }

    public static void main(String[] args) {
        leetcode1000 l = new leetcode1000();
//        int[] arr = {3, 2, 4, 1};
//        int k = 2;
//        int[] arr = {3, 5, 1, 2, 6};
//        int k = 3;
        int[] arr = {6, 4, 4, 6};
        int k = 2;
        int res = l.mergeStones(arr, k);
        System.out.println(res);
    }
}
