package 链表和数组;

/**
 * @author wangyh
 * @create 2020-02-13 14:42
 */

public class 删除链表的倒数第N个节点 {
		public ListNode removeNthFromEnd( ListNode head, int n ) {
				ListNode dummy = new ListNode( 0 );
				dummy.next = head;
				ListNode p = dummy, q = dummy;
				for( ; n > 0 && p.next != null; --n )
						p = p.next;
				if( n != 0 )
						return dummy.next;
				while( p.next != null ) {
						p = p.next;
						q = q.next;
				}
				q.next = p.next.next;
				return dummy.next;
		}
}
