package 二叉树和分治法;

/**
 * Created by wyh on 2019/6/1.
 */
public class 翻转二叉树 {
		//1.递归的定义：翻转二叉树
		public void invertBinaryTree( TreeNode root ) {
				//3.递归的出口
				if( root == null ) {
						return;
				}
				//2.递归的拆解
				TreeNode tmp = root.left;
				root.left = root.right;
				root.right = tmp;
				invertBinaryTree( root.left );
				invertBinaryTree( root.right );
		}
}
