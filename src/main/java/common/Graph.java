package common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xu_xt on 10/9/18.
 */
public class Graph{
    public List<GraphNode> nodes;
    Graph () {
        nodes = new ArrayList<>();
    }
    public class GraphNode {
        public int val;
        public List<GraphNode> neighbors;
        GraphNode (int val) {
            this.val = val;
            neighbors = new ArrayList<>();
        }
    }
}
