package 二叉树和分治法;

/**
 * Created by wyh on 2019/6/1.
 */
public class 二叉树叶子节点之和 {
		//1.递归的定义：二叉树叶子结点之和
		public int sumLeafNode( TreeNode root ) {
				//3.递归的出口
				if( root == null )
						return 0;
				if( root.right == null && root.left == null )
						return root.val;
				//2.递归的拆解
				int leftS = sumLeafNode( root.left );
				int rightS = sumLeafNode( root.right );
				return leftS + rightS;
		}

}
