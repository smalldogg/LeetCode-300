package 链表和数组;

public class 删除链表中倒数第n个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (head != null) {
            n--;
            head = head.next;
        }
        if (n == 0) {
            return dummy.next.next;
        }
        head = dummy;
        while (++n != 0) {
            head = head.next;
        }
        head.next = head.next.next;
        return dummy.next;
    }
}
