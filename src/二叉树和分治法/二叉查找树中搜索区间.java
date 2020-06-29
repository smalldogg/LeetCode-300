package 二叉树和分治法;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wyh on 2019/6/1.
 */
public class 二叉查找树中搜索区间 {

    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        List<Integer> result = new ArrayList<>();
        process(result, root, k1, k2);
        return result;
    }

    private void process(List<Integer> result, TreeNode node, int k1, int k2) {
        if (node == null) {
            return;
        }
        if (node.val > k1) {
            process(result, node.left, k1, k2);
        }
        if (node.val >= k1 && node.val <= k2) {
            result.add(node.val);
        }
        if (node.val < k2) {
            process(result, node.right, k1, k2);
        }
    }

}
