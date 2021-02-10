package BFS;

import java.util.*;

/**
 * Created by wyh on 2019/6/2.
 */
public class 搜索图中的点 {
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph, Map<UndirectedGraphNode, Integer> values, UndirectedGraphNode node,
                                          int target) {
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Set<UndirectedGraphNode> set = new HashSet<>();
        queue.offer(node);
        set.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            if (target == values.get(cur)) {
                return cur;
            }
            for (UndirectedGraphNode next : cur.neighbors) {
                if (!set.contains(next)) {
                    set.add(next);
                    queue.offer(next);
                }
            }
        }
        return null;
    }
}
