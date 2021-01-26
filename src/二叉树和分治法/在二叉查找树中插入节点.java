package 二叉树和分治法;

/**
 * Created by wyh on 2019/6/1.
 */
public class 在二叉查找树中插入节点 {
		//1.递归的定义：在二叉查找树中插入节点
		public TreeNode insertNode( TreeNode root, TreeNode node ) {
				//3.递归的出口
				if( root == null ) {
						return node;
				}
				//2.递归的拆解
				if( node.val < root.val ) {
						root.left = insertNode( root.left, node );
				} else {
						root.right = insertNode( root.right, node );
				}
				return root;
		}
}
