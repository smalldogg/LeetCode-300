package 二叉树和分治法;

/**
 * @author wangyh
 * @create 2020-02-13 14:48
 */

public class 二叉搜索树中节点的最近公共祖先 {
		public TreeNode lowestCommonAncestor( TreeNode root, TreeNode p, TreeNode q ) {
				if( p.val < root.val && q.val < root.val )
						return lowestCommonAncestor( root.left, p, q );
				else if( p.val > root.val && q.val > root.val )
						return lowestCommonAncestor( root.right, p, q );
				else
						return root;
		}

		public TreeNode lcaIterative( TreeNode root, TreeNode p, TreeNode q ) {
				while( root != null ) {
						if( p.val < root.val && q.val < root.val )
								root = root.left;
						else if( p.val > root.val && q.val > root.val )
								root = root.right;
						else
								return root;
				}
				return null;
		}



}
