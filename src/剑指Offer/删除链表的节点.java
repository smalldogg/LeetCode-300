package 剑指Offer;

/**
 * @author wangyh
 * @create 2020-02-13 11:45
 */

public class 删除链表的节点 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (head != null) {
            if (head.val == val)
                cur.next = head.next;
            else cur = cur.next;
            head = cur.next;
        }
        return dummy.next;
    }
}
