package 二叉树和分治法;

/**
 * Created by wyh on 2019/5/31.
 */
public class 二叉查找树的中序后继 {

		//如果该节点有右子节点, 那么后继是其右子节点的子树中最左端的节点
		//如果该节点没有右子节点, 那么后继是离它最近的祖先, 该节点在这个祖先的左子树内.


		//1.递归的定义：二叉查找树的中序后继
		public TreeNode inorderSuccessor( TreeNode root, TreeNode p ) {
				//3.递归的出口
				if( root == null || p == null ) {
						return null;
				}
				//2.递归的拆解
				if( p.val >= root.val ) {
						return inorderSuccessor( root.right, p );
				} else {
						//如果根节点小于或等于要查找的节点, 直接进入右子树递归
						//如果根节点大于要查找的节点, 则暂存左子树递归查找的结果
						//如果是 null, 则直接返回当前根节点; 反之返回左子树递归查找的结果
						TreeNode left = inorderSuccessor( root.left, p );
						return left == null ? root : left;
				}
		}
}
