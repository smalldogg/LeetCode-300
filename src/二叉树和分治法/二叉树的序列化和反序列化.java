package 二叉树和分治法;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wyh on 2019/6/1.
 */
public class 二叉树的序列化和反序列化 {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#!";
        }
        String res = root.val + "!";
        res += serialize(root.left);
        res += serialize(root.right);
        return res;
    }

    public TreeNode deserialize(String data) {
        String[] strs = data.split("!");
        Queue<String> queue = new LinkedList<>();
        for (String s : strs) {
            queue.offer(s);
        }
        return build(queue);
    }

    private TreeNode build(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(value));
        node.left = build(queue);
        node.right = build(queue);
        return node;
    }
}
