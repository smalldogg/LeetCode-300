package 链表和数组;

public class 旋转链表 {
		public ListNode rotateRight( ListNode head, int k ) {
				if( head == null || head.next == null ) {
						return head;
				}
				int len = getLen( head );

				ListNode last = head;
				ListNode cur = head;

				int loop = len - ( k % len );
				while( cur.next != null ) {
						cur = cur.next;
				}

				last = cur;
				cur.next = head;
				cur = head;

				for( int i = 0; i < loop; i++ ) {
						cur = cur.next;
						last = last.next;
				}

				last.next = null;
				return cur;
		}

		private int getLen( ListNode head ) {
				int len = 0;
				while( head != null ) {
						len++;
						head = head.next;
				}
				return len;
		}
}
