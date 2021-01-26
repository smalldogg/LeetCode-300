package 二叉树和分治法;

/**
 * Created by wyh on 2019/5/31.
 */
public class 最小子树 {

		private TreeNode subTree = null;

		private int sum = Integer.MAX_VALUE;

		//找到和最小的子树
		public TreeNode findSubtree( TreeNode root ) {
				help( root );
				return subTree;
		}

		private int help( TreeNode node ) {
				if( node == null ) {
						return 0;
				}
				int left = help( node.left );
				int right = help( node.right );
				int cur = left + right + node.val;
				if( cur < sum ) {
						sum = cur;
						subTree = node;
				}
				return cur;
		}


}
