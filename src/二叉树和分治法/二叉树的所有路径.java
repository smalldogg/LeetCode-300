package 二叉树和分治法;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wyh on 2019/6/1.
 */
public class 二叉树的所有路径 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> resuts = new ArrayList<>();
        if (root == null) return resuts;
        if (root.left == null && root.right == null) resuts.add(root.val + "");
        else {
            List<String> left = binaryTreePaths(root.left);
            List<String> right = binaryTreePaths(root.right);
            for (String path : left)
                resuts.add(root.val + "->" + path);
            for (String path : right)
                resuts.add(root.val + "->"+ path);

        }
        return resuts;
    }
}
