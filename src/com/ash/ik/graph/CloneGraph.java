package com.ash.ik.graph;

// Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.

// OJ's undirected graph serialization:
// Nodes are labeled uniquely.

// We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
// As an example, consider the serialized graph {0,1,2#1,2#2,2}.

// The graph has a total of three nodes, and therefore contains three parts as separated by #.

// First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
// Second node is labeled as 1. Connect node 1 to node 2.
// Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
// Visually, the graph looks like the following:

//        1
//       / \
//      /   \
//     0 --- 2
//          / \
//          \_/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Definition for undirected graph. class UndirectedGraphNode { int label; List<UndirectedGraphNode> neighbors;
 * UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); } };
 */

public class CloneGraph {

    static class UndirectedGraphNode {

        int label;

        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    private Map<Integer, UndirectedGraphNode> map = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

        if (node == null) {
            return null;
        }

        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }

        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node.label, newNode);

        for (UndirectedGraphNode neibour : node.neighbors) {
            newNode.neighbors.add(cloneGraph(neibour));
        }

        return newNode;
    }

    public static void main(String[] args) {

        CloneGraph o = new CloneGraph();

        /*
            Note : All the edges are Undirected
            Given Graph:
            1--2
            |  |
            4--3
        */

        UndirectedGraphNode n1 = new UndirectedGraphNode(1);
        UndirectedGraphNode n2 = new UndirectedGraphNode(2);
        UndirectedGraphNode n3 = new UndirectedGraphNode(3);
        UndirectedGraphNode n4 = new UndirectedGraphNode(4);

        List<UndirectedGraphNode> neibours = new ArrayList<>();
        neibours.add(n2);
        neibours.add(n4);
        n1.neighbors.addAll(neibours);

        neibours = new ArrayList<>();
        neibours.add(n1);
        neibours.add(n3);
        n2.neighbors.addAll(neibours);

        neibours = new ArrayList<>();
        neibours.add(n2);
        neibours.add(n4);
        n3.neighbors.addAll(neibours);

        neibours = new ArrayList<>();
        neibours.add(n1);
        neibours.add(n3);
        n4.neighbors.addAll(neibours);

        UndirectedGraphNode clonedGraph = o.cloneGraph(n1);
    }
}
