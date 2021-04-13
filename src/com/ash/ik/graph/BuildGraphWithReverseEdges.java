package com.ash.ik.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import com.sun.xml.internal.xsom.impl.SchemaImpl;

/**
 * Given A Graph, Build A New One With Reversed Edges
 * <p>
 * <p>
 * <p>
 * Given a strongly connected directed graph, build a new graph with the same number of nodes but every edge reversed .
 * This is also called transposing a graph.
 * <p>
 * <p>
 * <p>
 * Example
 * <p>
 * Input: Any node of this graph:
 * <p>
 * <p>
 * <p>
 * Output: Any node of the new:
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Notes
 * <p>
 * Input Parameters: Function has one argument pointing to a node of the given graph.
 * <p>
 * <p>
 * <p>
 * Output: Return any node of the new graph.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= number of nodes <= 315 Value in any node will be a unique integer between 1 and number of nodes, inclusive. No
 * multiple edges (connecting any pair of nodes in one direction) or self loops (edges connecting a node with itself) in
 * the input graph. You are not allowed to modify the given graph. Return a newly built graph.
 * <p>
 * <p>
 * Custom Input
 * <p>
 * Input Format: The first line of input contains two space separated integers n and m, denoting number of nodes and
 * number of edges in the input graph, respectively. Next m lines contain two space separated integers each: fromNode
 * and toNode, denoting that there is an edge from fromNode to toNode in G.
 * <p>
 * For example, if n = 3, m = 3 and edges = [(1 -> 2), (2 -> 3), (3 -> 1)], then input would be:
 * <p>
 * 3 3
 * <p>
 * 1 2
 * <p>
 * 2 3
 * <p>
 * 3 1
 * <p>
 * <p>
 * <p>
 * Output Format: There will be one line of output, containing a string "Wrong Answer!" OR "Correct Answer!", depending
 * on the evaluation of your solution’s output. For input n = 3, m = 3 and edges = [(1 -> 2), (2 -> 3), (3 -> 1)], if
 * your solution is correct, output will be:
 * <p>
 * Correct Answer!
 */
public class BuildGraphWithReverseEdges {


    /*
     * Complete the function below.
     */

    static class Node {

        Integer val;

        Vector<Node> neighbours = new Vector<Node>(0);

        Node(Integer _val) {
            val = _val;
            neighbours.clear();
        }
    }

    ;

    static Node build_other_graph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        Map<Integer, Boolean> visited = new HashMap<>();
        transformGraph(node, map, visited);

        Node parent = null;
        for (Map.Entry<Node, Node> entry : map.entrySet()) {
            parent = entry.getValue();
            for(Node n: entry.getKey().neighbours) {
                Node child = n;
                child.neighbours.add(parent);
            }
        }

        return map.get(node);
    }

    private static void transformGraph(Node node, Map<Node, Node> map, Map<Integer, Boolean> visited) {

        map.put(node, new Node(node.val));
        visited.put(node.val, true);

        for (Node n : node.neighbours) {
            if (!visited.get(n.val)) {
                transformGraph(n, map, visited);
            }
        }
    }
}
