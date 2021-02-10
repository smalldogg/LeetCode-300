package BFS;

import java.util.*;

/**
 * Created by wyh on 2019/6/2.
 */
public class 判断图是否是树 {

    //图是树的条件  1.所有点连通  2. n个点  n-1条边
    public boolean validTree(int n, int[][] edges) {
        if (n == 0) return false;

        if (edges.length != n - 1) return false;

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        Map<Integer, Set<Integer>> graph = init(n, edges);
        //从一个点出发，找到所有的点
        set.add(0);
        queue.add(0);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (Integer neighbor : graph.get(node)) {
                if (set.contains(neighbor)) {
                    continue;
                }
                set.add(neighbor);
                queue.offer(neighbor);
            }
        }
        return set.size() == n;

    }

    //点和边的集合
    private Map<Integer, Set<Integer>> init(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int i = 0; i < edges.length; ++i) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(v).add(u);
            graph.get(v).add(u);
        }
        return graph;
    }
}
