package 二叉树和分治法;

/**
 * Created by wyh on 2019/6/1.
 */
public class 验证满二叉树 {
		//1.递归的定义：验证满二叉树
		public boolean isFullTree( TreeNode root ) {
				//3.递归的出口
				if( root == null ) {
						return true;
				}
				if( root.right == null && root.left != null || root.left == null && root.right != null ) {
						return false;
				}
				//2.递归的拆解
				boolean left = isFullTree( root.left );
				if( !left ) {
						return false;
				}
				boolean right = isFullTree( root.right );
				if( !right ) {
						return false;
				}
				return true;
		}

}
