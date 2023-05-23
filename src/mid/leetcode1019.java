package mid;

import java.util.*;

public class leetcode1019 {
    /*
    链表中的下一个更大节点
    https://leetcode.cn/problems/next-greater-node-in-linked-list/
     */
//    public int[] nextLargerNodes(ListNode head) {
//        List<Integer> list = new ArrayList<>();
//        int size = 0;
//        while (head != null) {
//            list.add(head.val);
//            size++;
//            head = head.next;
//        }
//        int[] res = new int[size];
//        Deque<Integer> deque = new ArrayDeque<>();
//        for (int i=size-1;i>=0;i--){
//            while (!deque.isEmpty()&&deque.peek()<=list.get(i)){
//                deque.pop();
//            }
//            if (!deque.isEmpty()){
//                res[i] = deque.peek();
//            }
//            deque.push(list.get(i));
//        }
//        return res;
//    }
}
