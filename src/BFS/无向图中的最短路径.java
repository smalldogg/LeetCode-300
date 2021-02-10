package BFS;

import java.util.*;

/**
 * Created by wyh on 2019/6/2.
 */
public class 无向图中的最短路径 {


    public int shortestPath(List<UndirectedGraphNode> graph, UndirectedGraphNode A, UndirectedGraphNode B) {
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        int cnt = 0;
        Set<UndirectedGraphNode> set = new HashSet<>();
        queue.offer(A);
        set.add(A);
        while (!queue.isEmpty()) {
            cnt++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                UndirectedGraphNode node = queue.poll();
                for (UndirectedGraphNode next : node.neighbors) {
                    if (next == B) {
                        return cnt;
                    }
                    if (!set.contains(next)) {
                        queue.offer(next);
                        set.add(next);
                    }
                }
            }
        }
        return -1;
    }
}
