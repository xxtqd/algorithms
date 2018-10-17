package cc189.ch4;

import common.Graph;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xu_xt on 10/9/18.
 */
public class Q4_1 {
    public boolean connected(Graph graph, Graph.GraphNode start, Graph.GraphNode target) {
        if (!graph.nodes.contains(start) || !graph.nodes.contains(target)) {
            return false;
        }
        if (start.neighbors.size() == 0 || target.neighbors.size() == 0) {
            return false;
        }
        Set<Graph.GraphNode> visited = new HashSet<>();
        visited.add(start);
        return search(start, target, visited);
    }

    private boolean search (Graph.GraphNode start, Graph.GraphNode target, Set<Graph.GraphNode> visited) {
        if (start == target) {
            return true;
        }
        for (Graph.GraphNode neighbor : start.neighbors) {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                if (search(neighbor, target, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}



