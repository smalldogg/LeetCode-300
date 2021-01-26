package 二叉树和分治法;

/**
 * Created by wyh on 2019/6/1.
 */
public class 删除二叉查找树的节点 {
		//1.递归的定义：删除二叉查找树的节点
		public TreeNode removeNode( TreeNode root, int value ) {
				if( root == null ) {
						return root;
				}
				if( root.val < value ) {
						root.right = removeNode( root.right, value );
				} else if( root.val > value ) {
						root.left = removeNode( root.left, value );
				} else {
						if( root.left == null ) {
								return root.right;
						} else if( root.right == null ) {
								return root.left;
						} else {
								TreeNode leftMax = root.left;
								while( leftMax.right != null ) {
										leftMax = leftMax.right;
								}
								leftMax.right = root.right;
								root = root.left;
						}
				}
				return root;
		}
}
