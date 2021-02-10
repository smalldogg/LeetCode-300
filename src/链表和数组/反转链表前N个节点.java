package 链表和数组;

/**
 * @author wangyh
 * @create 2020-12-29 18:23
 */

public class 反转链表前N个节点 {
    ListNode NPlusNode = null;

    ListNode reverseN(ListNode head, int n) {
        //base case
        if (n == 1) {
            NPlusNode = head.next;
            return head;
        }
        ListNode node = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = NPlusNode;


        return null;
    }
}
