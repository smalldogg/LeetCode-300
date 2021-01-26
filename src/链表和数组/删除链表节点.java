package 链表和数组;

/**
 * @author wangyh
 * @create 2020-02-13 15:04
 */

public class 删除链表节点 {
		public void deleteNode( ListNode node ) {
				node.val = node.next.val;
				node.next = node.next.next;
		}
}
