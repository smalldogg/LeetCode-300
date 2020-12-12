package 链表和数组;

public class 删除排序链表中的重复元素 {
		public ListNode deleteDuplicates( ListNode head ) {
				if( head == null ) {
						return head;
				}
				ListNode dummy = new ListNode( 0 );
				dummy.next = head;
				while( head.next != null ) {
						if( head.val == head.next.val ) {
								head.next = head.next.next;
						} else {
								head = head.next;
						}
				}
				return dummy.next;
		}
}
