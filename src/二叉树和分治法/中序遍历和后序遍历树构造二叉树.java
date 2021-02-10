package 二叉树和分治法;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wyh on 2019/6/1.
 */
public class 中序遍历和后序遍历树构造二叉树 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return build(postorder, 0, postorder.length - 1, 0, inMap);
    }

    private TreeNode build(int[] post, int start, int end, int inStart, Map<Integer, Integer> inMap) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(post[end]);
        int rootIdx = inMap.get(post[end]);
        int leftLen = rootIdx - inStart;
        root.left = build(post, start, start + leftLen - 1, inStart, inMap);
        root.right = build(post, start + leftLen, end - 1, rootIdx + 1, inMap);
        return root;
    }
}
