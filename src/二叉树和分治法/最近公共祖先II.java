package 二叉树和分治法;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wyh on 2019/5/31.
 */
public class 最近公共祖先II {


    class ParentTreeNode {
        public ParentTreeNode parent, left, right;
    }

    //从根节点开始，第一个不同的节点就是
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        List<ParentTreeNode> pathA = getPathNodes(A);
        List<ParentTreeNode> pathB = getPathNodes(B);
        ParentTreeNode result = null;
        int idxA = pathA.size() - 1;
        int idxB = pathB.size() - 1;
        while (idxA >= 0 && idxB >= 0) {
            if (pathA.get(idxA) != pathB.get(idxB)) {
                break;
            }
            result = pathA.get(idxA);
            idxA--;
            idxB--;
        }
        return result;
    }

    private List<ParentTreeNode> getPathNodes(ParentTreeNode node) {
        List<ParentTreeNode> path = new ArrayList<>();
        while (node != null) {
            path.add(node);
            node = node.parent;
        }
        return path;
    }

}
