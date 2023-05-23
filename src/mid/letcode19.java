package mid;

public class letcode19 {
    /*
    删除链表的倒数第 N 个结点
    https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
     */
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode fast = head;
//        ListNode slow = head;
//        for (int i = 0; i < n; i++) {
//            if (fast.next == null) {
//                return head.next;
//            } else {
//                fast = fast.next;
//            }
//        }
//        while (fast.next != null) {
//            fast = fast.next;
//            slow = slow.next;
//        }
//        slow.next = (slow.next).next;
//        return head;
//    }
}
