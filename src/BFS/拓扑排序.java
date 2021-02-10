package BFS;

import java.util.*;

/**
 * Created by wyh on 2019/6/2.
 */
public class 拓扑排序 {
    class DirectedGraphNode {
        int label;
        ArrayList<DirectedGraphNode> neighbors;

        DirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<DirectedGraphNode>();
        }
    }

    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> result = new ArrayList<>();
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        Map<DirectedGraphNode, Integer> inMap = new HashMap<>();
        //1. 建立每个节点的入度
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (inMap.containsKey(neighbor)) {
                    inMap.put(neighbor, inMap.get(neighbor) + 1);
                } else {
                    inMap.put(neighbor, 1);
                }
            }
        }

        // 2. 找度为 0 的节点
        for (DirectedGraphNode node : graph) {
            if (!inMap.containsKey(node)) {
                result.add(node);
                queue.add(node);
            }
        }

        // 3. 消除影响
        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            for (DirectedGraphNode neighbor : node.neighbors) {
                inMap.put(neighbor, inMap.get(neighbor) - 1);
                if (inMap.get(neighbor) == 0) {
                    queue.add(neighbor);
                    result.add(neighbor);
                }
            }
        }
        return result;
    }
}
