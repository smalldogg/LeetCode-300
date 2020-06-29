package LeetCode._1229;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author wangyh
 * @create 2019-12-29 10:36
 */

public class 两棵二叉搜索树中的所有元素 {
    public List<Integer> getAllElements(TreeNode root1,
                                        TreeNode root2) {
        List<Integer> result = new ArrayList<>();
        List<Integer> list1 = inOrder(root1, result);
        List<Integer> list2 = inOrder(root2, result);
        Collections.sort(result);
        return result;
    }

    private List<Integer> inOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return null;
        }
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
        return list;
    }
}
