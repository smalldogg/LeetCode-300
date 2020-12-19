package 二叉树和分治法;

/**
 * @author wangyh
 * @create 2020-11-17 9:56
 */

public class 二叉搜索树的第k大节点 {

		private int result;

		public int kthLargest( TreeNode root, int k ) {
				dfs( root, k );
				return result;
		}

		private void dfs( TreeNode node, int k ) {
				if( node == null )
						return;
				if( k == 0 ) {
						result = node.val;
						return;
				}
				dfs( node.right, k-- );
				dfs( node.left, k-- );
		}
}
