package 链表和数组;

public class K组翻转链表 {
		public ListNode reverseKGroup( ListNode head, int k ) {
				if( head == null || head.next == null ) {
						return null;
				}
				ListNode dummy = new ListNode( 0 );
				dummy.next = head;
				ListNode pre = dummy;
				while( pre != null ) {
						pre = rever( pre, k );
				}
				return dummy.next;
		}

		private ListNode rever( ListNode head, int k ) {
				ListNode n1 = head.next;
				ListNode cur = head;
				for( int i = 0; i < k; i++ ) {
						if( cur == null ) {
								return null;
						}
						cur = cur.next;
				}
				if( cur == null ) {
						return null;
				}
				ListNode nk = cur;
				ListNode nkPlus = cur.next;
				ListNode pre = head;
				cur = head.next;
				ListNode next = null;
				while( cur != nkPlus ) {
						next = cur.next;
						cur.next = pre;
						pre = cur;
						cur = next;
				}
				head.next = nk;
				n1.next = nkPlus;
				return n1;
		}
}
