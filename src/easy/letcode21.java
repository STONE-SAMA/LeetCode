package easy;

public class letcode21 {
    /*
    合并两个有序链表
    https://leetcode.cn/problems/merge-two-sorted-lists/
     */
//    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        if(list1==null && list2==null){
//            return null;
//        }
//        if(list1!=null && list2==null){
//            return list1;
//        }
//        if(list1==null && list2!=null){
//            return list2;
//        }
//        ListNode node;
//        if(list1.val<=list2.val){
//            node = list1;
//            list1 = list1.next;
//        }else{
//            node = list2;
//            list2 = list2.next;
//        }
//        ListNode temp = node;
//        while(list1!=null&&list2!=null){
//            if(list1.val<list2.val){
//                temp.next = list1;
//                temp = list1;
//                list1 = list1.next;
//            }else{
//                temp.next = list2;
//                temp = list2;
//                list2 = list2.next;
//            }
//        }
//        if(list1!=null){
//            temp.next = list1;
//        }else{
//            temp.next = list2;
//        }
//        return node;
//    }
}
