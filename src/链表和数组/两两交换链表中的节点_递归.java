package 链表和数组;

public class 两两交换链表中的节点_递归 {
    public ListNode swapPairs(ListNode head) {
        //找终止条件
        if (head == null || head.next == null) {
            return head;
        }
        //找返回值
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        //本层递归应该做什么
        next.next = head;
        return  next;
    }
}
