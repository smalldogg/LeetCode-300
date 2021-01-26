package 二叉树和分治法;

/**
 * Created by wyh on 2019/6/1.
 */
public class 具有最大平均数的子树 {
		public class ReturnType {
				public int sum;
				public int size;

				public ReturnType( int sum, int size ) {
						this.sum = sum;
						this.size = size;
				}
		}


		private ReturnType subResult;
		private TreeNode subTree;

		public TreeNode findSubtree2( TreeNode root ) {
				help( root );
				return subTree;
		}

		//1.递归的定义：找到具有最大平均数最大的子树
		private ReturnType help( TreeNode node ) {
				//3.递归的出口
				if( node == null ) {
						return new ReturnType( 0, 0 );
				}
				//2.递归的拆解
				ReturnType left = help( node.left );
				ReturnType right = help( node.right );
				ReturnType result = new ReturnType( left.sum + right.sum + node.val, left.size + right.size + 1 );

				if( subTree == null || result.size * subResult.sum < result.sum * subResult.size ) {
						subResult = result;
						subTree = node;
				}
				return result;
		}

}
