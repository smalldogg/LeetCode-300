package 链表和数组;

/**
 * @author wangyh
 * @create 2020-11-20 18:32
 */

public class 对链表进行插入排序 {
		/**
		 * 链表只能从前向后遍历，所以遍历节点向后插入
		 *
		 * @param head
		 * @return
		 */
		public ListNode insertionSortList( ListNode head ) {
				if( head == null )
						return head;
				ListNode dummy = new ListNode( 0 );
				dummy.next = head;
				ListNode cur = head.next, last = head;
				while( cur != null ) {
						if( last.val > cur.val )
								last = last.next;
						else {

						}

				}
				return dummy.next;
		}
}
