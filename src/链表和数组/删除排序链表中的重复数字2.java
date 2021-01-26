package 链表和数组;

public class 删除排序链表中的重复数字2 {
		public ListNode deleteDuplicates( ListNode head ) {
				if( head == null || head.next == null ) {
						return head;
				}
				ListNode dummy = new ListNode( 0 );
				dummy.next = head;
				head = dummy;
				while( head.next != null && head.next.next != null ) {
						//找到一个不等于head.val的节点，连接
						if( head.next.val == head.next.next.val ) {
								int val = head.next.val;
								while( head.next != null && head.next.val == val ) {
										head.next = head.next.next;
								}
						} else {
								head = head.next;
						}
				}
				return dummy.next;
		}
}
