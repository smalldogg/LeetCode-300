package 链表和数组;

public class 翻转链表 {
    public ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


    /**
     * 使用递归的方式
     *
     * @param head
     * @return
     */
    public ListNode reverse2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode node = reverse2(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}
