package 二叉树和分治法;

import java.util.*;

/**
 * Created by wyh on 2019/5/31.
 */
public class 二叉树的层次遍历II {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // write your code here
       List<List<Integer>> results = new ArrayList<>();
       if (root == null) {
           return results;
       }
       Queue<TreeNode> queue = new LinkedList<>();
       queue.add(root);
       while (!queue.isEmpty()) {
           List<Integer> list = new ArrayList<>();
           int size = queue.size();
           for (int i = 0; i < size; i++) {
               TreeNode cur = queue.poll();
               list.add(cur.val);
               if (cur.left != null) {
                   queue.add(cur.left);
               }
               if (cur.right != null) {
                   queue.add(cur.right);
               }
           }
           results.add(list);
       }
       Collections.reverse(results);
       return results;
    }
}
