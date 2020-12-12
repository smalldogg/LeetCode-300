package 二叉树和分治法;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangyh
 * @create 2020-08-08 9:40
 */


public class 寻找重复的子树 {
    /**
     * 后序遍历
     *
     * @param root
     * @return
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        List<TreeNode> res = new ArrayList<>();
        dfs(root, map, res);
        return res;
    }

    private String dfs(TreeNode node, Map<String, Integer> map, List<TreeNode> res) {
        if (node == null)
            return "#";
        String leftPath = dfs(node.left, map, res);
        String rightPath = dfs(node.right, map, res);
        String path = node.val + leftPath + rightPath;
        map.put(path, map.getOrDefault(path, 0) + 1);
        if (map.get(path) == 2)
            res.add(node);
        return path;
    }

}
