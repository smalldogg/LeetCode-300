package 二叉树和分治法;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wyh on 2019/6/1.
 */
public class 二叉树的路径和 {

    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        process(root, root.val, target, list, result);
        return result;
    }

    //1.递归的定义：找到指定值的二叉树的路径和
    private void process(TreeNode root, int sum, int target,
                         List<Integer> list, List<List<Integer>> result) {
        //3.递归的出口
        if (root.left == null && root.right == null) {
            if (sum == target) {
                result.add(new ArrayList<>(list));
            }
            return;
        }
        if (root.left != null) {
            list.add(root.left.val);
            process(root.left, sum + root.left.val, target, list, result);
            list.remove(list.size() - 1);
        }
        if (root.right != null) {
            list.add(root.right.val);
            process(root.right, sum + root.right.val, target, list, result);
            list.remove(list.size() - 1);
        }
    }
}
