package 二叉树和分治法;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by wyh on 2019/6/1.
 */
public class BST中第K小的元素 {
		public int kthSmallest( TreeNode root, int k ) {

				Queue<Integer> q = new LinkedList<>( );
				queues( root, q );
				int res = 0;
				while( k != 0 ) {
						res = q.poll( );
						k--;
				}
				return res;
		}

		private void queues( TreeNode node, Queue<Integer> queue ) {
				if( node == null ) {
						return;
				}
				queues( node.left, queue );
				queue.offer( node.val );
				queues( node.right, queue );
		}

		public int kthSmallest2( TreeNode root, int k ) {
				Map<TreeNode, Integer> numOfChildren = new HashMap<>( );
				countNodes( root, numOfChildren );
				return quickSelectOnTree( root, k, numOfChildren );
		}

		private int countNodes( TreeNode root, Map<TreeNode, Integer> numOfChildren ) {
				if( root == null ) {
						return 0;
				}

				int left = countNodes( root.left, numOfChildren );
				int right = countNodes( root.right, numOfChildren );
				numOfChildren.put( root, left + right + 1 );
				return left + right + 1;
		}

		private int quickSelectOnTree( TreeNode root, int k, Map<TreeNode, Integer> numOfChildren ) {
				if( root == null ) {
						return -1;
				}

				int left = root.left == null ? 0 : numOfChildren.get( root.left );
				if( left >= k ) {
						return quickSelectOnTree( root.left, k, numOfChildren );
				}
				if( left + 1 == k ) {
						return root.val;
				}

				return quickSelectOnTree( root.right, k - left - 1, numOfChildren );
		}
}
