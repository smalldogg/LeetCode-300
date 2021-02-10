package 链表和数组;

/**
 * @author wangyh
 * @create 2020-02-17 21:33
 */

public class 单链表中间节点 {
    public ListNode getMiddleNodeOnePass(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
