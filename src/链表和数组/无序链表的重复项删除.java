package 链表和数组;

import java.util.HashSet;
import java.util.Set;

public class 无序链表的重复项删除 {

		public ListNode removeDuplicates( ListNode head ) {
				if( head == null || head.next == null ) {
						return head;
				}
				ListNode node = head;
				Set<Integer> set = new HashSet<>( );
				set.add( head.val );
				while( node.next != null ) {
						if( set.contains( node.next.val ) ) {
								node.next = node.next.next;
						} else {
								set.add( node.next.val );
								node = node.next;
						}
				}
				return head;
		}
}
